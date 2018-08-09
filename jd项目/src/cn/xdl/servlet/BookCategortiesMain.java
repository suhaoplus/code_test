package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.services.CategoryService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class BookCategortiesMain
 */
public class BookCategortiesMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CategoryService cs  =new CategoryService();
		String parent_id = request.getParameter("parent_id");
		List<Category> list = cs.subCategories(Integer.parseInt(parent_id));
		String jsonStr = JSONArray.fromObject(list).toString();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(jsonStr);
		pw.close();
		
	}

}
