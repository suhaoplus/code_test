package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.UserService;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserInfo
 */
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		request.getRequestDispatcher("userInfo.jsp").forward(request, response);
		
	}

}
