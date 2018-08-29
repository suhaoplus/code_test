package cn.xdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.UserService;

/**
 * Servlet implementation class UserRegisterController
 */
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受页面请求的参数，登录名、密码、邮箱、推荐人
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String recommender = request.getParameter("recommender");
		//根据请求参数，创建User对象
		User user = new User(login_name, password, email, recommender);
		//创建服务对象
		UserService us = new UserService();
		//调用服务对象的注册方法，并使用flag接收返回值
		boolean flag = us.register(user);
		if(flag) {
			//注册成功！跳转到注册成功页面！
			response.sendRedirect("registerOk.jsp");
		}else {
			//注册失败！向页面发送注册失败！并转发到注册页面！
			request.setAttribute("msg", "注册失败！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
