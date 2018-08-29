package cn.xdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.News;
import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.NewsService;
import cn.xdl.esms.services.ProductService;

/**
 * Servlet implementation class BookMain
 */
public class BookMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		CategoryService cs  =new CategoryService();
		NewsService ns = new NewsService();
		List<News> list2 = ns.subNews(5);
		request.setAttribute("list2", list2);
		ProductService ps = new ProductService();
		List<Product> list3 = ps.showProductList(29, "publish_time", "desc", 1, 8);
		request.setAttribute("hotnewbooks", list3);
		List<Product> list4 = ps.showProductList(22, "lower_price", "asc", 1, 8);
		request.setAttribute("list4", list4);
		List<Product> list5 = ps.showProductList(26, "total_page", "desc", 1, 8);
		request.setAttribute("list5", list5);
//		List<Category> list = cs.subCategories(0);
//		System.out.println(list);
//		request.setAttribute("list", list);
		request.getRequestDispatcher("book.jsp").forward(request, response);
	}

}
