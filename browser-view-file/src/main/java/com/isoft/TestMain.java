package com.isoft;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class TestMain {
	private static String filePath="K:/资料.txt";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//filePath="E:/资料temp.txt";
		
		
		File file=new File(filePath);
		InputStream in=FileUtils.openInputStream(file);
		
		List<String> list=IOUtils.readLines(in, "GBK");
		String line=null;
		int total=0;
		for(int i=0;i<list.size();i++){
			line=list.get(i);//.replaceAll(" ", "").replaceAll("	", "")
			if(!line.isEmpty()){
				total++;
				System.out.println(line);
			}
			
		}
		if(null!=in){
			in.close();
		}
		System.out.println(total);

		System.out.println("<<<<<<<>>>>>>>");
	}

}
