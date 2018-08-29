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
 * Servlet implementation class UpdateUserNick
 * updateUserNick.do
 */
public class UpdateUserNick extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService us = new UserService();
		String value = request.getParameter("value");
		User user = (User) request.getSession().getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(user==null) {
			pw.write("未登录！");
		}
		int user_id = user.getUser_id();
		boolean flag = us.updateNick(value, user_id);
		if(flag) {
			pw.write("修改成功！");
		}else {
			pw.write("修改失败！");
		}
	}

}
