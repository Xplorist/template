package template.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import template.dao.BlogDao;
import util.config.ConfigReader;

@WebServlet({ "/TextSaveServlet" })
public class TextSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		initProperty(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initProperty(request, response);

		String func = request.getParameter("func");
		String str1;
		switch ((str1 = func).hashCode()) {
		case -2073141569:
			if (str1.equals("saveBlog")) {
				break;
			}
			break;
		case -191566193:
			if (!str1.equals("queryFiles")) {
				saveBlog();
			} else {
				queryFiles();
			}
			break;
		}
	}

	public void initProperty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		this.request = request;
		this.response = response;
	}

	public void saveBlog() throws ServletException, IOException {
		String blogTitle = this.request.getParameter("blogTitle");
		String blogContent = this.request.getParameter("blogContent");

		String dirPath = ConfigReader.getPropertyByPath("config/file.properties", "fileDirectory");
		String storedTitle = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + blogTitle + ".txt";
		String filePath = dirPath + File.separator + storedTitle;
		File dir = new File(dirPath);
		File file = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		BlogDao dao = new BlogDao();
		dao.addFile(blogTitle + ".txt", storedTitle, filePath);

		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
		blogTitle = blogTitle + "\r\n" + System.getProperty("line.separator") + "    ";
		writer.write(blogTitle, 0, blogTitle.length());
		writer.write(blogContent, 0, blogContent.length());
		writer.flush();
		writer.close();

		String backInfo = "<h1>success to save your textInfo !</h1><a href='index.html'>back to first page</a>";

		this.response.getWriter().write(backInfo);

		this.response.sendRedirect("html/listBlog.html");
	}

	public void queryFiles() throws ServletException, IOException {
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public static long getSerialversionuid() {
		return 1L;
	}
}
