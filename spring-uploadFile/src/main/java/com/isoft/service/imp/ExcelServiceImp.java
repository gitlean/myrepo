package com.isoft.service.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoft.bean.Drug;
import com.isoft.service.IExcelService;

@Service
public class ExcelServiceImp implements IExcelService{
	@Override
    public void saveBath(List<String[]> list) {
        for (String[] strings : list) {
            Drug drug = new Drug();
            drug.setName(strings[0]);
            drug.setSpecification(strings[1]);
            drug.setUnit(strings[2]);
            //drug.setPrice(strings[3]);  //这种方法会导致价格出现如下数字：16.399999999999999  77.900000000000006
            BigDecimal bd = new BigDecimal(strings[3]);
            bd = bd.setScale(1,BigDecimal.ROUND_HALF_UP);
            String price = bd.toString();
            if("0".equals(price.substring(price.length()-1))){ //如果最后一位是0  如 26.0元  33.0元 就把 .0 删除
                String newPrice = price.substring(0, price.length()-2);
                drug.setPrice(newPrice);
            }else{
                drug.setPrice(price);
            }
            drug.setStatus("0");
            drug.setDrug_classify("8afa9409591f762b01591ffa62ff0006");
            this.save(drug);
        }
    }
	
	
	
}
