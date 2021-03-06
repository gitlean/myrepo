package com.isoft.blueberry.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoft.entity.Film;
import com.isoft.service.IMyService;

@Controller
@RequestMapping(value = "/excelDownloadManager")
public class ExcelDownloadManager {
	static Logger logger = LoggerFactory.getLogger(ExcelDownloadManager.class);  
	
	@Autowired
	IMyService service;
	
	@RequestMapping(value = "/exportExcel")
	public void exportExcel(HttpServletResponse response) throws IOException {
		logger.debug("ExcelDownloadManager--------->exportExcel");
		List<Film> list=service.queryList();
		System.out.println(list);
		
		
		//System.out.println("Got it...");
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("sheet1");
		int rowid=0;
		int columnid=0;
		HSSFRow row=null;
		Cell cell=null;
		for(rowid=0;rowid<list.size();rowid++){
			columnid=0;
			Film film=list.get(rowid);
			row=sheet.createRow(rowid);
			cell=row.createCell(columnid++);
			cell.setCellValue(film.getId());
			
			cell=row.createCell(columnid++);
			cell.setCellValue(film.getFname());
		}
		
		
		
		String fileName="";
		fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+".xls";
		

		
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		response.setContentType("application/x-download");
		wb.write(response.getOutputStream());
		response.flushBuffer();
		
	}
	

	
	
	
}
