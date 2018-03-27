package com.isoft.blueberry.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoft.util.PathUtil;

@Controller
@RequestMapping(value = "/excelDownloadManager")
public class ExcelDownloadManager {
	static Logger logger = LoggerFactory.getLogger(ExcelDownloadManager.class);  
	
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(HttpServletResponse response) throws IOException {
		//System.out.println("Got it...");
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("sheet1");
		int rowid=0;
		int columnid=0;
		HSSFRow row=null;
		Cell cell=null;
		for(rowid=0;rowid<10;rowid++){
			row=sheet.createRow(rowid);
			for(columnid=0;columnid<4;columnid++){
				cell=row.createCell(columnid);
				cell.setCellValue("中");
			}
		}
		
		
		
		String fileName="";
		fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+".xls";
		

		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		response.setContentType("application/x-download");
		wb.write(response.getOutputStream());
		response.flushBuffer();
		
	}
	

	
	
	
}
