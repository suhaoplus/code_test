package cn.xdl.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;

/**
 * Servlet implementation class OrderSuccess
 */
public class OrderSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map<Product,Integer>map = (Map<Product, Integer>) request.getSession().getAttribute("productList");
		double sum =0;
		int count=0;
		Set<Map.Entry<Product,Integer>> s1= map.entrySet();
		for(Map.Entry<Product,Integer>me:s1) {
			sum += me.getKey().getLower_price()*me.getValue();
			count+=me.getValue();
		}
		request.setAttribute("sum", sum);
		request.getRequestDispatcher("orderSuccess.jsp").forward(request, response);;
	}

}
