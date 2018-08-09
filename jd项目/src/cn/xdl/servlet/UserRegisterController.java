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
		//����ҳ������Ĳ�������¼�������롢���䡢�Ƽ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String login_name = request.getParameter("login_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String recommender = request.getParameter("recommender");
		//�����������������User����
		User user = new User(login_name, password, email, recommender);
		//�����������
		UserService us = new UserService();
		//���÷�������ע�᷽������ʹ��flag���շ���ֵ
		boolean flag = us.register(user);
		if(flag) {
			//ע��ɹ�����ת��ע��ɹ�ҳ�棡
			response.sendRedirect("registerOk.jsp");
		}else {
			//ע��ʧ�ܣ���ҳ�淢��ע��ʧ�ܣ���ת����ע��ҳ�棡
			request.setAttribute("msg", "ע��ʧ�ܣ�");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
