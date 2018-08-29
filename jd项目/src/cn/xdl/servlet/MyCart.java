package cn.xdl.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.InterestService;
import cn.xdl.esms.services.ProductService;

/**
 * Servlet implementation class MyCart
 */
public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		String cname = request.getParameter("cname");
		ProductService ps = new ProductService();
		Map<Product,Integer> map = (Map<Product, Integer>) request.getSession().getAttribute("productList"); 
		request.setAttribute("maps", map);	
		request.setAttribute("cname", cname);
		InterestService is = new InterestService();
		Map<Product, Timestamp> map2 = is.findInterestAll();
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			request.setAttribute("maps2", map2);
		}		
		request.getRequestDispatcher("myCart.jsp").forward(request, response);
	}

}
