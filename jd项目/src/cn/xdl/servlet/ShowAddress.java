package cn.xdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xdl.esms.bean.Address;
import cn.xdl.esms.services.AddressService;

/**
 * Servlet implementation class ShowAddress
 * showAddress.do
 */
public class ShowAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		AddressService as = new AddressService();
		List<Address> list = as.findAddrAll();
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("dzgl.jsp").forward(request, response);
	}

}
