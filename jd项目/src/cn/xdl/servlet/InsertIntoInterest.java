package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.InterestService;

/**
 * Servlet implementation class InsertIntoInterest
 */
public class InsertIntoInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(user!=null) {
			int user_id = user.getUser_id();
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			String bak = request.getParameter("bak");
			InterestService is = new InterestService();
			boolean flag1 = is.selectInterest(product_id);
			if(flag1) {
				pw.write("该商品已经在收藏夹了！");
			}else {
				boolean flag2 = is.insertInterest(user_id, product_id, bak);
				if(flag2) {
					pw.write("收藏成功！");
				}else {
					pw.write("收藏失败！");
				}
			}

			pw.close();
		}else {
			pw.write("收藏失败！请登录！");
		}
	}

}
