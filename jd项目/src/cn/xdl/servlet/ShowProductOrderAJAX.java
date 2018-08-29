package cn.xdl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.services.ProductService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class showProductBySale
 */
public class ShowProductOrderAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String category_id = request.getParameter("cid");
		String flag = request.getParameter("flag");
		String orderStd = request.getParameter("orderStd");
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		ProductService ps = new ProductService();
		List<Product> productList =null;
		if("true".equals(flag)) {
			productList = ps.showProductList(Integer.parseInt(category_id), orderStd, "desc", Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
		}else {
			productList = ps.showProductList(Integer.parseInt(category_id), orderStd, " ", Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
		}			
		String str = JSONArray.fromObject(productList).toString();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(str);
		pw.close();
		
	}

}
