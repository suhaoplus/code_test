package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.dao.UserDAO;
import cn.xdl.util.DBCPUtil;
import cn.xdl.util.Md5Util;

/**
 * 用户操作DAO的实现类
 *
 * @author cz
 *
 */
public class UserDaoImpl implements UserDAO {

    /**
     * 用户表操作DAO接口的实现方法
     */
    @Override
    public int insertUser(User user) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "insert into xdl_user(login_name,password,email,recommender)"
                + "values(?,?,?,?)";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLogin_name());
            ps.setString(2, Md5Util.md5Str(user.getPassword()));
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRecommender());
            // 执行sql语句
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, null);
        }
        return 0;
    }

    /**
     * 通过登录名查询用户是否存在的方法
     */
    @Override
    public boolean findUserByLoginName(String login_name) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_user where login_name =?";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, login_name);
            // 执行sql语句
            rs = ps.executeQuery();
            // 根据结果返回Boolean
            return rs.next() ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, rs);
        }
        return false;
    }

    /*
     * --------------------------------------返回值类型欠妥--------------------------------
     * ------------------
     *
     * @Override public boolean findUser(String login_name, String password) {
     * //创建连接对象 Connection conn = null; //创建执行对象 PreparedStatement ps=null;
     * //创建结果集对象 ResultSet rs = null; //获取连接 conn = DBCPUtil.getConnection();
     * //准备sql语句 String
     * sql="select * from xdl_user where login_name =?and password=?"; try {
     * //预编译sql语句 ps=conn.prepareStatement(sql); ps.setString(1, login_name);
     * ps.setString(2, Md5Util.md5Str(password)); //执行sql语句 rs = ps.executeQuery();
     * //根据结果返回Boolean return rs.next()?true:false; } catch (SQLException e) {
     * e.printStackTrace(); }finally { //释放资源 DBCPUtil.close(conn, ps, rs); } return
     * false; }
     * -----------------------------------------------------------------------------
     * ----------------
     */
    /**
     * 通过用户名和密码查询用户的方法
     */
    @Override
    public User findUser(String login_name, String password) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_user where login_name =?and password=?";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, login_name);
            ps.setString(2, Md5Util.md5Str(password));
            // 执行sql语句
            rs = ps.executeQuery();
            // 根据结果返回User对象
            if (rs.next()) {
                User user = new User();
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setBirth(rs.getTimestamp("birth"));
                user.setNick_name(rs.getString("nick_name"));
                user.setReal_name(rs.getString("real_name"));
                user.setGrade_id(rs.getInt("grade_id"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setProvince(rs.getString("province"));
                user.setRecommender(rs.getString("recommender"));
                user.setSex(rs.getString("sex"));
                user.setLocation(rs.getString("location"));
                user.setSchool(rs.getString("school"));
                user.setCompany(rs.getString("company"));
                user.setCard_number(rs.getString("card_number"));
                user.setMobile(rs.getString("mobile"));
                user.setPhone(rs.getString("phone"));
                user.setMsn(rs.getString("msn"));
                user.setQq(rs.getString("qq"));
                user.setWebsite(rs.getString("website"));
                user.setSend_address(rs.getString("send_address"));
                user.setZipcode(rs.getString("zipcode"));
                user.setHobby(rs.getString("hobby"));
                user.setVerify_flag(rs.getString("verify_flag"));
                user.setVerify_code(rs.getString("verify_code"));
                user.setLast_login_ip(rs.getString("last_login_ip"));
                user.setLast_login_time(rs.getTimestamp("last_login_time"));
                user.setArea(rs.getString("area"));
                user.setHead_pic(rs.getString("head_pic"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public boolean update(String login_name, String oldpassword, String newpassword) {

        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_user where login_name =?and password=?";
        String sq2 = "update xdl_user set password=? where login_name =?";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, login_name);
            ps.setString(2, Md5Util.md5Str(oldpassword));
            // 执行sql语句
            rs = ps.executeQuery();
            // 根据结果返回User对象
            if (rs.next()) {
                System.out.println("flag=ok");
                ps = conn.prepareStatement(sq2);
                ps.setString(1, Md5Util.md5Str(newpassword));
                ps.setString(2, login_name);
                int row = ps.executeUpdate();
                System.out.println(row);
                return row == 1 ? true : false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, rs);
        }
        return false;
    }

    //修改昵称
    @Override
    public boolean updateNick(String value, int user_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "update xdl_user set nick_name = ? where user_id =?";
        // 获得执行对象
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ps.setInt(2, user_id);
            int row = ps.executeUpdate();
            return row == 1 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, null);
        }
        return false;
    }

    @Override
    public User findUser(String login_name) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备sql语句
        String sql = "select * from xdl_user where login_name =?";
        try {
            // 预编译sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, login_name);
            // 执行sql语句
            rs = ps.executeQuery();
            // 根据结果返回User对象
            if (rs.next()) {
                User user = new User();
                user.setLogin_name(rs.getString("login_name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setBirth(rs.getTimestamp("birth"));
                user.setNick_name(rs.getString("nick_name"));
                user.setReal_name(rs.getString("real_name"));
                user.setGrade_id(rs.getInt("grade_id"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setProvince(rs.getString("province"));
                user.setRecommender(rs.getString("recommender"));
                user.setSex(rs.getString("sex"));
                user.setLocation(rs.getString("location"));
                user.setSchool(rs.getString("school"));
                user.setCompany(rs.getString("company"));
                user.setCard_number(rs.getString("card_number"));
                user.setMobile(rs.getString("mobile"));
                user.setPhone(rs.getString("phone"));
                user.setMsn(rs.getString("msn"));
                user.setQq(rs.getString("qq"));
                user.setWebsite(rs.getString("website"));
                user.setSend_address(rs.getString("send_address"));
                user.setZipcode(rs.getString("zipcode"));
                user.setHobby(rs.getString("hobby"));
                user.setVerify_flag(rs.getString("verify_flag"));
                user.setVerify_code(rs.getString("verify_code"));
                user.setLast_login_ip(rs.getString("last_login_ip"));
                user.setLast_login_time(rs.getTimestamp("last_login_time"));
                user.setArea(rs.getString("area"));
                user.setHead_pic(rs.getString("head_pic"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBCPUtil.close(conn, ps, rs);
        }
        return null;
    }
}
