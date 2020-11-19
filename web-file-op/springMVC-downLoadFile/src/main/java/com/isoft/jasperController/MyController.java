package com.isoft.jasperController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isoft.bean.QualityInspectionProduct;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
*@author anonymous
*@createTime 2020年3月31日 下午2:52:56
*@describe 
*/

@Controller
@RequestMapping(value = "/fileDownload")
public class MyController {
	 /**
     * 2）带参数的导出
     * @throws Exception
     */
    @RequestMapping("/exportPdf")
    public void exportPdf(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	HttpSession session = request.getSession();
        //1.读取.japser文件，构建输入流
        InputStream in = session.getServletContext().getResourceAsStream("/jasper/test03_parameter.jasper");

        //2.构建Print对象，用于让模块结合数据
        //第二个参数就是用来填充模板中的parameters
        Map<String, Object> map = new HashMap<>();
        map.put("userName","小泽sss");
        map.put("email","ze@qq.com");
        map.put("schoolName","oxford");
//        map.put("companyName","小泽科技");
//        map.put("deptName","视频组");

        JasperPrint print = JasperFillManager.fillReport(in,map,new JREmptyDataSource());

        //3.使用Exporter导出PDF
        JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());

    }
    
    
    
    @RequestMapping("/exportPdf2")
    public void exportPdf2(HttpServletRequest request,HttpServletResponse response) {
    	HttpSession session = request.getSession();
        //1.读取.japser文件，构建输入流
        InputStream in = session.getServletContext().getResourceAsStream("/jasper/test04_parameter.jasper");

        //2.构建Print对象，用于让模块结合数据
        //注意：JavaBean的属性名称和模版的Fileds的名称一致的
        List<QualityInspectionProduct> list = new ArrayList<QualityInspectionProduct>();
        for(int i=1;i<=10;i++){
        	QualityInspectionProduct product = new QualityInspectionProduct();
          
        	product.setProductCode("code"+i);
            product.setPropertyCode("property"+i);
            product.setProductName("mname"+i);
            product.setQuantity("quantity"+i);
            product.setRack("rack"+i);
            list.add(product);
        }

        
        
        Map<String,Object> parameters=new HashMap<String,Object>();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        parameters.put("productList", dataSource);
        
        parameters.put("myParaa", "你好");
        parameters.put("myParab", "dfdff你好fdgfd");
        
        
		try {
			//JasperPrint print = JasperFillManager.fillReport(in,parameters);
			//JasperPrint print = JasperFillManager.fillReport(in,parameters,new JRBeanCollectionDataSource(null));
			JasperPrint print = JasperFillManager.fillReport(in,parameters,new JREmptyDataSource());
			
			
			 
			  //3.使用Exporter导出PDF
	        JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
     
     
    }
    
    
    
}
