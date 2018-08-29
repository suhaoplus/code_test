package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.UserService;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String oldpassword = request.getParameter("oval");
		String newpassword = request.getParameter("nval");
		System.out.println(oldpassword+":"+newpassword);
		User user = (User) request.getSession().getAttribute("user");
		String login_name=user.getLogin_name();
		System.out.println(login_name);
		PrintWriter pw = response.getWriter();
		UserService us = new UserService();
		boolean flag = us.update(login_name, oldpassword, newpassword);
		if(flag) {
			pw.write("密码修改成功！请使用新密码重新登录！");
		}else {
			pw.write("密码修改失败！");
		}
		pw.close();
	}

}
