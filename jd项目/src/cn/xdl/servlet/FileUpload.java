package cn.xdl.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 * fileUpload.do
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 创建一个磁盘条目工厂对象
		DiskFileItemFactory  dfif = new  DiskFileItemFactory();
		// 创建 Servlet 文件上传对象
		ServletFileUpload  sfu = new ServletFileUpload(dfif);
		try {
			List<FileItem> items = sfu.parseRequest(request);
			for(FileItem it : items){
				// 判断是普通字段 还是文件字段
				if(it.isFormField()){
					// 这是普通字段
					System.out.println(it.getFieldName() + ":" + it.getString());
				}else{
					// 这是文件字段
					System.out.println(it.getFieldName() + ":" + it.getSize());
					//String filePath = "E:/datas";
					String  filePath = request.getServletContext()
							.getRealPath("imgs");
					System.out.println("filePath:"+filePath);
					String fileName = System.currentTimeMillis()
							+ it.getName();
					File file  = new File(filePath + "/" + fileName);
					try {
						it.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 放入数据库 或者 给下一个页面显示的路径  相对于webCotent的路径
					PrintWriter pw = response.getWriter();
					pw.write("imgs/"+fileName);
							/*request.setAttribute("imgPath", "imgs/"+fileName);
							request.getRequestDispatcher("show.jsp")
							   .forward(request, response);*/
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
