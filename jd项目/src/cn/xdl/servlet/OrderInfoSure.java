package cn.xdl.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.ProductService;

/**
 * Servlet implementation class OrderInfoSure
 */
public class OrderInfoSure extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp");
		}else {
			Map<Product,Integer>map = (Map<Product, Integer>) request.getSession().getAttribute("productList");
			ProductService ps= new ProductService();
					double sum =0;
					int count=0;
					Set<Entry<Product,Integer>> s1= map.entrySet();
					for(Entry<Product,Integer>me:s1) {
						sum += me.getKey().getLower_price()*me.getValue();
						count+=me.getValue();
					}
			request.setAttribute("maps", map);
			request.setAttribute("user", user);
			request.setAttribute("sum", sum);
			request.setAttribute("count", count);
			request.getRequestDispatcher("editOrderInfo.jsp").forward(request, response);
		}
		
		}
	}


