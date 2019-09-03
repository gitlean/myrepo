package com.isoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isoft.bean.UserProperties;

/**
*@author john
*@createTime 2019年9月2日 上午11:20:34
*@describe 
*/
@RunWith(SpringRunner.class)  
@SpringBootTest 
public class YamlTest {
    @Autowired  
    private UserProperties userProperties;  
  
    @Test  
    public void testYaml() {  
        System.out.println(userProperties.getUserName() + "-" + userProperties.getGender());  
    }  
}
