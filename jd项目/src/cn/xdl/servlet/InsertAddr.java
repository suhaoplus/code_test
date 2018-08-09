package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.AddressService;

/**
 * Servlet implementation class InsertAddr
 * insertAddr.do
 */
public class InsertAddr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = (User)request.getSession().getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(user==null) {
			pw.write("没有登录！");
		}else {
			int user_id = user.getUser_id();
			String receive_name = request.getParameter("receive_name");
			String province = request.getParameter("province");
			String address = request.getParameter("address");
			String zipcode = request.getParameter("zipcode");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");

			AddressService as = new AddressService();
			boolean flag = as.insertAddr(user_id, receive_name, province, address, zipcode, mobile, null, email, null);
			if(flag) {
				pw.write("添加到地址簿成功！");
			}else {
				pw.write("添加到地址簿时发生错误！");
			}
		}

	}

}
