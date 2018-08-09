package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.dao.InterestDAO;
import cn.xdl.util.DBCPUtil;

public class InterestDaoImpl implements InterestDAO {

    @Override
    public boolean insertInterest(int user_id, int product_id,String bak) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        //准备sql语句
        String sql = "insert into xdl_interest(user_id, product_id, collect_time, bak) values(?,?,now(),?)";
        //获取执行对象
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setInt(2, product_id);
            ps.setString(3, bak);
            int row = ps.executeUpdate();
            return row==1?true:false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean selectInterest(int product_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        //创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_interest where product_id = ?";
        // 获取执行对象
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            //获取结果集
            rs = ps.executeQuery();
            return rs.next()?true:false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBCPUtil.close(conn, ps, rs);
        }

        return false;
    }

    @Override
    public Map<Product,Timestamp> findInterestAll() {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        //创建List集合
        List<Product>list = new ArrayList<Product>();
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_interest i ,xdl_product p where i.product_id = p.product_id";
        //准备一个Map
        Map<Product,Timestamp> map = new HashMap<Product,Timestamp>();
        // 获取执行对象
        try {
            ps = conn.prepareStatement(sql);
            // 获取结果集
            rs = ps.executeQuery();
            while(rs.next()) {
                Product product = null;
                int product_id =rs.getInt("product_id");
                String name = rs.getString("name"); // 产品名
                String keywords = rs.getString("keywords"); // 关键字
                Timestamp add_time =rs.getTimestamp("add_time"); // 上架时间
                String picture = rs.getString("picture"); // 产品图片
                String big_picture = rs.getString("big_picture"); // 放大图片
                double fixed_price =rs.getDouble("fixed_price"); // 定价
                double lower_price=rs.getDouble("lower_price"); // 京东价
                String description = rs.getString("description"); // 产品描述
                String author = rs.getString("author"); // 作者
                String publishing = rs.getString("publishing"); // 出版社
                Timestamp publish_time=rs.getTimestamp("publish_time"); // 出版时间
                String isbn = rs.getString("isbn"); // ISBN编号
                String language = rs.getString("language"); // 语种
                String which_edtion = rs.getString("which_edtion"); // 版次
                String total_page = rs.getString("total_page"); // 页数
                String bind_layout = rs.getString("bind_layout"); // 装帧
                String book_size = rs.getString("book_size"); // 开本
                String editor_description = rs.getString("editor_description"); // 编辑推荐描述
                String catalog = rs.getString("catalog"); // 目录
                String book_summary = rs.getString("book_summary"); // 内容简介
                String author_summary = rs.getString("author_summary"); // 作者简介
                String extracts = rs.getString("extracts"); // 精彩书斋
                Timestamp print_time=rs.getTimestamp("print_time"); // 印刷时间
                int print_number=rs.getInt("print_number"); // 印刷数量
                String paper_type = rs.getString("paper_type"); // 纸张类型
                String print_frequency = rs.getString("print_frequency"); // 印次
                product = new Product(product_id, name, keywords, add_time,
                        picture, big_picture, fixed_price, lower_price, description,
                        author, publishing, publish_time, isbn, language, which_edtion,
                        total_page, bind_layout, book_size, editor_description, catalog,
                        book_summary, author_summary, extracts, print_time, print_number,
                        paper_type, print_frequency);
                Timestamp collect_time = rs.getTimestamp("collect_time");
                map.put(product, collect_time);
            }
            return map;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBCPUtil.close(conn, ps, rs);
        }

        return null;
    }

    @Override
    public boolean delInterestByProductId(int product_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "delete from xdl_interest where product_id = ?";
        // 获取执行对象
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            // 获取结果集
            int row = ps.executeUpdate();
            return row==1? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBCPUtil.close(conn, ps, null);
        }
        return false;
    }

}
