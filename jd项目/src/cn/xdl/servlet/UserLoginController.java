package cn.xdl.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.UserService;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*String s_login_name = (String) request.getSession().getAttribute("login_name");
		String s_password = (String) request.getSession().getAttribute("password");
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		if(s_login_name!=null&&s_password!=null) {
			
		}else {
			UserService us = new UserService();
			//boolean flag = us.login(login_name, password);
			response.setContentType("text/html;charset=utf-8");
			if(flag) {
				request.getSession().setAttribute("login_name", login_name);
				request.getSession().setAttribute("password", password);
				request.getRequestDispatcher("book_list.jsp");
			}else {
				response.getWriter().write("用户名或密码错误！");
				response.getWriter().close();
			}
		}*/
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		UserService us = new UserService();
		User user = us.login(login_name, password);
		if(user==null) {
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("user", user);
			//response.sendRedirect("book.jsp");
			Map<Product,Integer> map = (Map<Product, Integer>) request.getSession().getAttribute("productList");
			if(map==null) {
				response.sendRedirect("bookMain.do");
			}
			else if(map.isEmpty()){
				response.sendRedirect("myCart.do");
			}else {
				response.sendRedirect("orderInfoSure.do");
			}


		}
	}


}
