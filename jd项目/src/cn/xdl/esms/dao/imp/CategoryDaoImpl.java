package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.dao.CategoryDAO;
import cn.xdl.util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDAO {

    @Override
    public List<Category> getCategoryListByParentId(int parent_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备一个List集合
        List<Category> list = new ArrayList<Category>();
        // 准备sql语句
        String sql = "select * from xdl_category where parent_id=?";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setInt(1, parent_id);
            // 执行sql语句
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                category.setTurn(rs.getInt("turn"));
                category.setDescription(rs.getString("description"));
                category.setParent_id(rs.getInt("parent_id"));
                list.add(category);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, rs);
        }
        return null;
    }
}
