package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.services.UserService;

/**
 * Servlet implementation class UserCheck
 */
public class UserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("userloginname");
		System.out.println(username);
		UserService us = new UserService();
		boolean flag = us.checkUserLoginName(username);
		PrintWriter pw = response.getWriter();
		if(flag) {
			pw.write("用户已存在!");
		}else {
			pw.write("格式正确!");
		}
	}

}
