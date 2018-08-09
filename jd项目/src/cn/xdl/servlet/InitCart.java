package cn.xdl.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.bean.User;
import cn.xdl.esms.services.ProductService;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class InitCart
 * 加入购物车的方法
 */
public class InitCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//设置响应的编码格式
		response.setContentType("text/html;charset=utf-8");
		//获取请求参数
		int  product_id = Integer.parseInt(request.getParameter("product_id"));
		System.out.println(product_id);
		int  num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		String cname = request.getParameter("cname");
		//System.out.println("product_id="+product_id);
		//根据请求参数查询商品
		ProductService ps = new ProductService();
		Product product = ps.showProductDetail(product_id);
		//设置属性值
//		request.setAttribute("product", product);
//		request.setAttribute("num", num);
		request.setAttribute("cname", cname);
		//用于存放产品
		/*Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			if("product".equals(cookie.getName())) {
				JSONObject json = JSONObject.fromObject(cookie.getValue());
				Map m = (Map)json;
				Set<Map.Entry<Product,Integer>> s1= m.entrySet();
				for(Map.Entry<Product,Integer>me:s1) {
					if(me.getKey().getProduct_id()==product_id) {
						m.put(product, me.getValue()+1);
					}else {

						//准备一个Map集合，键是Product类型，值是num数量
						Map<Product,Integer>map = new HashMap<Product,Integer>();
						map.put(product, num);
						String jsonStr = JSONObject.fromObject(map).toString();
						//判断用户是否登录
						User user = (User) request.getSession().getAttribute("user");
						Cookie cookie1 = null;
						if(user==null) {
							//未登录
							cookie1 = new Cookie("username","default");
						}else {
							//登录了
							String username = user.getLogin_name();
							cookie1 = new Cookie("username",username);
						}
						Cookie cookie2 = new Cookie("product",jsonStr);
						cookie1.setMaxAge(1800);
						cookie2.setMaxAge(1800);
						cookie1.setPath("/");
						cookie2.setPath("/");
						response.addCookie(cookie1);
						response.addCookie(cookie2);

					}
				}
			}
		}
		*/

		Map<Product,Integer> map = (Map<Product, Integer>) request.getSession().getAttribute("productList");
		if(map==null) {
			//准备一个Map集合，键是Product类型，值是num数量
			map = new ConcurrentHashMap<Product,Integer>();
			map.put(product, num);
		}else if(map.isEmpty()){
			map.put(product, num);
		}else{
			Set<Map.Entry<Product,Integer>> s1= map.entrySet();
			Iterator<Entry<Product, Integer>> iterator=s1.iterator();
			while(iterator.hasNext()) {
				Entry<Product, Integer> entry=iterator.next();
				System.out.println(entry.getKey().getProduct_id()==product_id);
				if(entry.getKey().getProduct_id()==product_id) {
					map.put(entry.getKey(), entry.getValue()+num);
				}else {
					map.put(product, num);
				}
			}
		}
		//计算总价
		double sum =0;//总价
		int count=0;//总数量
		Set<Map.Entry<Product,Integer>> s1= map.entrySet();
		for(Map.Entry<Product,Integer>me:s1) {
			sum += me.getKey().getLower_price()*me.getValue();
			count+=me.getValue();
		}
		System.out.println("sum="+sum);
		/*//存到session中
		request.getSession().setAttribute("map", map);		*/
		System.out.println(map);
		List<Product> list1 = ps.findProductByCategoryId(29);
		List<Product> list2 = ps.findProductByCategoryId(22);
		request.getSession().setAttribute("productList", map);
		request.setAttribute("maps", map);
		request.getSession().setAttribute("sum", sum);
		request.setAttribute("huowunum", count);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		//转发到购物车页面
		request.getRequestDispatcher("initCart.jsp").forward(request, response);
	}

}
