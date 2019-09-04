package com.isoft.test;
import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
  
public class DateTest {  
    public static void main(String[] args) throws ParseException {  
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        //format.setLenient(false);  
        Date date = format.parse("33/12/2011");  
        System.out.println(date);  
    }  
}  