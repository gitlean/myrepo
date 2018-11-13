package com.learndemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learndemo.bean.Emp;

/**
 * 测试demo的controller
 *
 * @author zcc ON 2018/2/8
 **/
@Controller
@RequestMapping(value = "/mvc")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello")
    public String hello(Model model) {

        String name = "jiangbei";
        model.addAttribute("name", name);
        
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(1, "校长", 24));
        empList.add(new Emp(2, "书记", 28));
        empList.add(new Emp(3, "小海", 25));
        model.addAttribute("empList", empList);
        
        
        return "hello";
    }
}