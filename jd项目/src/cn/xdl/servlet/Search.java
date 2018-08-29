package cn.xdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.ProductService;


public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String value = new String(request.getParameter("value").getBytes("iso-8859-1"), "utf-8");
		System.out.println("___"+value);
		ProductService ps = new ProductService();
		List<Product> list = ps.findProductByKeyWord(value);
		List<Product> list2 = ps.showProductList(29, "print_number", "desc", 1, 5);
		request.setAttribute("list2", list2);
		request.setAttribute("products", list);
		request.setAttribute("value", value);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
	}

}
