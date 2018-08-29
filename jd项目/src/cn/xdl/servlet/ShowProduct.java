package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Category;
import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.ProductService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ShowProduct
 */
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String category_id = request.getParameter("category_id");
		ProductService ps= new ProductService();
		List<Product> list = ps.findProductByCategoryId(Integer.parseInt(category_id));
		String str = JSONArray.fromObject(list).toString();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.close();
		
	}

}
