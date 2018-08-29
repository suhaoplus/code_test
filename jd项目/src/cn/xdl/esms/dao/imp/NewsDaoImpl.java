package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.xdl.esms.bean.News;
import cn.xdl.esms.dao.NewsDAO;
import cn.xdl.util.DBCPUtil;

public class NewsDaoImpl implements NewsDAO {

    @Override
    public List<News> getNews(int number) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBCPUtil.getConnection();
        List<News> list = new ArrayList<News>();
        String sql = "select * from xdl_news order by release_time desc";
        try {
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, number);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                news.setRelease_time(rs.getTimestamp("release_time"));
                news.setSticky(rs.getString("sticky"));
                list.add(news);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBCPUtil.close(conn, ps, rs);
        }
        return null;
    }

}
