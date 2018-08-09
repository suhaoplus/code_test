package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckImgCode
 */
@WebServlet("/checkImgCode.do")
public class CheckImgCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request,
						   HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String code = request.getParameter("code");
		// 从session 中取出答案
		String  answer = (String)request.getSession().getAttribute("number");
		String  msg = "";
		if(answer.equals(code)){
			msg = "验证码正确";
		}else{
			msg = "验证码错误";
		}
		PrintWriter  pw = response.getWriter();
		pw.write(msg);
		pw.close();
	}

}




