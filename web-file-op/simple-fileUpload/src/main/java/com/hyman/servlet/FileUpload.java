package com.hyman.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String uploadFileDir;

	private ServletContext sc;

	public FileUpload() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		uploadFileDir = config.getInitParameter("uploadDir");
		sc = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String simpleFileName = "";
		String fileDir = sc.getRealPath("/") + uploadFileDir;
		String message = "文件上传成功！";
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024); // 20KB
			factory.setRepository(factory.getRepository());
			ServletFileUpload upload = new ServletFileUpload(factory);
			int maxSize = 2 * 1024 * 1024; // 2MB
			List formlists = null;
			try {
				formlists = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator iterator = formlists.iterator();
			while (iterator.hasNext()) {
				FileItem formitem = (FileItem) iterator.next();
				if (formitem.isFormField()) {
					String fieldname = formitem.getFieldName();
					// 这里是非上传文件的表单域，可以通过formitem.getString(fieldname)来获取相应表单字段的值
				} else {
					// 这里是上传文件的表单域
					String name = formitem.getName();
					if (formitem.getSize() > maxSize) {
						message = "您上传的文件太大，请重新选择不超过2M的文件";
						break;
					}
					String fileSize = new Long(formitem.getSize()).toString();
					if (name == null || "".equals(name) && "0".equals(fileSize))
						continue;
					int delimiter = name.lastIndexOf("\\");
					simpleFileName = delimiter == -1 ? name : name.substring(delimiter + 1);
					File saveFile = new File(fileDir, simpleFileName);
					try {
						formitem.write(saveFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		request.setAttribute("result", message);
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	}

}