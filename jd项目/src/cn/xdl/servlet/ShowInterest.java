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

/**
 * Servlet implementation class ShowInterest
 */
public class ShowInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		InterestService is = new InterestService();
		Map<Product, Timestamp> map = is.findInterestAll();
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp");
		}else {
			request.setAttribute("maps", map);
			request.getRequestDispatcher("favor.jsp").forward(request, response);
		}
		
	}
}
