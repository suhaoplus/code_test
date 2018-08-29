package cn.xdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.ProductService;

/**
 * Servlet implementation class BookDetailShow
 * bookDetailShow.do
 */
public class BookDetailShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String cname=request.getParameter("cname");
		ProductService ps = new ProductService();
		Product product = ps.showProductDetail(product_id);
		request.setAttribute("product", product);
		request.setAttribute("cname", cname);
		request.getRequestDispatcher("bookDetail.jsp").forward(request, response);
	}

}
