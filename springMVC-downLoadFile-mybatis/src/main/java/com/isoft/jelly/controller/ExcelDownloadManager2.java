package com.isoft.jelly.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;

import com.isoft.util.PathUtil;

@Controller
@RequestMapping(value = "/excelDownloadManager2")
public class ExcelDownloadManager2 {
	static Logger logger = LoggerFactory.getLogger(ExcelDownloadManager2.class);

	@RequestMapping(value = "/exportExcel2")
	public void exportExcel(HttpServletResponse response) throws IOException {
		// System.out.println("Got it...");
		String a=this.getClass().getClassLoader().getResource("").getPath();//获取工程classes下的路径，这个方法可以在任意jsp，servlet，java文件中使用
		
		//在spring中,可以通过
		String b= ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");  //来获取。
		
		System.out.println(a+"\r\n"+b);
		
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		
		//这里可以设置样式
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY); //自适应
		style.setBorderRight(HSSFCellStyle.BORDER_THIN); //右部有细线

		style.setWrapText(true);

		
		int rowid = 0;
		int columnid = 0;
		HSSFRow row = null;
		Cell cell = null;
		for (rowid = 0; rowid < 10; rowid++) {
			row = sheet.createRow(rowid);
			for (columnid = 0; columnid < 4; columnid++) {
				cell = row.createCell(columnid);
				cell.setCellValue("中");
			}
		}

		String fileName = "";
		fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".xls";

		// 先保存
		File file = generateFile(fileName, wb);

		// 再下载
		String absolutePath = file.getAbsolutePath();
		logger.debug("absolutePath---->" + absolutePath);
		try {
			downloadFile(response, absolutePath, "f_" + fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 保存文件
	 * 
	 * @param fileName
	 * @param wb
	 * @return
	 */
	static File generateFile(String fileName, HSSFWorkbook wb) {
		String fileUrl = PathUtil.getClasspath() + "files/" + fileName;
		logger.debug("fileUrl:" + fileUrl);

		File f = new File(fileUrl);

		try {
			FileOutputStream fout = new FileOutputStream(f.getAbsoluteFile());
			wb.write(fout);
			fout.flush();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

	/**
	 * 
	 * @param response
	 * @param absolutePath
	 * @param alias
	 *            下载文件别名
	 */
	static void downloadFile(final HttpServletResponse response, String absolutePath, String alias) throws Exception {
		InputStream Input = new FileInputStream(absolutePath);

		// 把文件写入byte数组,可以用传统IO，也可以用channel来实现，还可以用IOUtils
		// 将流转为byte数组,用IOUtils.toByteArray 很方便
		byte[] data = IOUtils.toByteArray(Input);
		

		// 设置response头部
		response.reset();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(alias.getBytes("gb2312"), "iso-8859-1"));
		// response.setHeader("Content-Disposition",
		// "attachment;filename="+alias);

		// response.addHeader("Content-Length",""+data.length);

		response.setContentType("application/octet-stream;charset=UTF-8");

		// 写入response
		OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		outputStream.write(data);
		outputStream.flush();
		outputStream.close();

		response.flushBuffer();
	}

}
