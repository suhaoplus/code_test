package cn.xdl.esms.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.bean.Product;
import cn.xdl.esms.dao.ProductDAO;
import cn.xdl.util.DBCPUtil;

public class ProductDaoImpl implements ProductDAO {

    @Override
    public List<Product> findProductByParentId(int cotegory_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备一个List集合
        List<Product> list = new ArrayList<Product>();

        Product pro = null;
        // 准备sql语句
        String sql = "select * from xdl_product p inner join xdl_category_product cp on p.product_id=cp.product_id where category_id =?";
        //+ "order by print_number";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cotegory_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
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

                pro = new Product(product_id, name, keywords, add_time,
                        picture, big_picture, fixed_price, lower_price, description,
                        author, publishing, publish_time, isbn, language, which_edtion,
                        total_page, bind_layout, book_size, editor_description, catalog,
                        book_summary, author_summary, extracts, print_time, print_number,
                        paper_type, print_frequency);
                list.add(pro);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findProductList(int category_id, String orderStd, String orderType, int pageNumber,
                                         int pageSize) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备一个List集合
        List<Product> list = new ArrayList<Product>();
        // 准备sql语句
        // 最内层 负责排序
        String sql = "select p.* from xdl_product p,xdl_category_product cp "
                + " where p.product_id = cp.product_id and cp.category_id = ? " + " order by " + orderStd + " "
                + orderType + "  limit ?,?";
        // 中间层 负责编号 部分过滤 起别名
//		sql = "select rownum r, t.* from (" + sql + ") t where rownum < ? ";
//		// 最外层 负责 使用别名结合大于进行过滤
//		sql = "select * from ( " + sql + " ) where r > ?";
        try {
            ps = conn.prepareStatement(sql);
            // 设置占位符
            ps.setInt(1, category_id);
            ps.setInt(2, (pageNumber - 1) * pageSize);
            ps.setInt(3, (pageSize * pageNumber) + 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                // 使用结果集数据构建 产品对象
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPicture(rs.getString("picture"));
                product.setPublish_time(rs.getTimestamp("publish_time"));
                product.setFixed_price(rs.getDouble("fixed_price"));
                product.setLower_price(rs.getDouble("lower_price"));
                product.setAuthor(rs.getString("author"));
                product.setPublishing(rs.getString("publishing"));
                product.setPrint_number(rs.getInt("print_number"));
                product.setDescription(rs.getString("description"));
                list.add(product);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBCPUtil.close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public Product findProductDetailById(int product_id) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备一个List集合
        List<Product> list = new ArrayList<Product>();
        // 准备sql语句
        String sql = "select * from xdl_product where product_id=?";
        Product product =null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            while (rs.next()) {
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

            }
            return product;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> findProductByKeyWord(String keyWord) {
        // 创建连接对象
        Connection conn = null;
        // 创建执行对象
        PreparedStatement ps = null;
        // 创建结果集对象
        ResultSet rs = null;
        // 获取连接
        conn = DBCPUtil.getConnection();
        // 准备一个List集合
        List<Product> list = new ArrayList<Product>();
        Product pro = null;
        // 准备sql语句
        String sql = "select * from xdl_product where keywords like '%"+keyWord+"%' or name like '%"+keyWord+"%'";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
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

                pro = new Product(product_id, name, keywords, add_time,
                        picture, big_picture, fixed_price, lower_price, description,
                        author, publishing, publish_time, isbn, language, which_edtion,
                        total_page, bind_layout, book_size, editor_description, catalog,
                        book_summary, author_summary, extracts, print_time, print_number,
                        paper_type, print_frequency);
                list.add(pro);
            }
            System.out.println(list);
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
