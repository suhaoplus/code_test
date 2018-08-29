package cn.xdl.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;

/**
 * Servlet implementation class MyCartReduce
 */
public class MyCartReduce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int  product_id = Integer.parseInt(request.getParameter("product_id"));
		Map<Product,Integer> map  = (Map<Product, Integer>) request.getSession().getAttribute("productList");		
		
		Set<Entry<Product,Integer>> s1= map.entrySet();
		Iterator<Entry<Product, Integer>> iterator=s1.iterator();
		while(iterator.hasNext()) {
			Entry<Product, Integer> entry=iterator.next();
			if(entry.getKey().getProduct_id()==product_id) {
				map.put(entry.getKey(), entry.getValue()-1);
			}
		}
	}
}
