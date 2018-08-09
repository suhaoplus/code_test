package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.services.InterestService;

/**
 * Servlet implementation class DelInterest
 */
public class DelInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		InterestService is = new InterestService();
		boolean flag = is.delInterestByProductId(product_id);
		PrintWriter pw = response.getWriter();
		if(flag) {
			pw.write("取消成功！");
		}else {
			pw.write("取消失败！");
		}
	}

}
