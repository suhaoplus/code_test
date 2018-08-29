package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xdl.esms.bean.Address;
import cn.xdl.esms.dao.AddressDAO;
import cn.xdl.util.DBCPUtil;

public class AddressDaoImpl implements AddressDAO {

    @Override
    public boolean insertAddr(int user_id, String receive_name, String province, String address, String zipcode,
                              String mobile, String telephone, String email, String area) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = DBCPUtil.getConnection();
        String sql = "insert into xdl_receive_address(user_id, receive_name, province, address, zipcode, mobile, telephone, email, area) values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, receive_name);
            ps.setString(3, province);
            ps.setString(4, address);
            ps.setString(5, zipcode);
            ps.setString(6, mobile);
            ps.setString(7, telephone);
            ps.setString(8, email);
            ps.setString(9, area);
            int row = ps.executeUpdate();
            return row == 1 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBCPUtil.close(conn, ps, null);
        }

        return false;
    }

    @Override
    public List<Address> findAddrAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBCPUtil.getConnection();
        String sql = "select * from xdl_receive_address ";
        List<Address> list =new ArrayList<Address>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Address addr = new Address();
                int reveiveAddressId =rs.getInt("reveive_address_id");
                int userId = rs.getInt("user_id");
                String name = rs.getString("receive_name");
                String province = rs.getString("province");
                String address = rs.getString("address");
                String zipcode = rs.getString("zipcode");
                String mobile = rs.getString("mobile");
                String tel = rs.getString("telephone");
                String email = rs.getString("email");
                String area = rs.getString("area");
                list.add(new Address(reveiveAddressId,userId,name, province, address, zipcode, mobile, tel, email, area));
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBCPUtil.close(conn, ps, null);
        }


        return null;
    }

}
