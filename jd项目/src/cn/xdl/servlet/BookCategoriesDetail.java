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
import cn.xdl.esms.services.CategoryService;
import cn.xdl.esms.services.ProductService;

/**
 * Servlet implementation class BookCategoriesDetail
 */
public class BookCategoriesDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String parent_id = request.getParameter("category_id");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		request.setAttribute("name", name);
		System.out.println(new String(name.getBytes(),"utf-8"));
		System.out.println("----------------"+name);

		CategoryService cs = new CategoryService();
		List<Category> bookcategories = cs.subCategories(Integer.parseInt(parent_id));
		request.setAttribute("bookcategories", bookcategories);
		//获取第一个默认分类对象
		int category_id =-1;
		if(!bookcategories.isEmpty()){
			Category category = bookcategories.get(0);
			category_id = category.getCategory_id();
		}
		request.setAttribute("cid", category_id);
		//构建一个产品对应的service类，获取对应的产品列表
		ProductService ps = new ProductService();
		List<Product> productList = ps.showProductList(category_id, "print_number", "  ", 1, 4);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}

}
