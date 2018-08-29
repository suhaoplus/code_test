package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.ProductService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class NewHotProduct
 * newHotProduct.do
 */
public class NewHotProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProductService ps = new ProductService();
		List<Product> productList = ps.showProductList(22, "print_number", "desc", 1, 3);
		String str = JSONArray.fromObject(productList).toString();
		PrintWriter pw = response.getWriter();
		pw.write(str);
		
	}

}
