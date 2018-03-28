package com.newer.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.login.bean.User;
import com.newer.login.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserService userService = new UserService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 1、获得页面参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("获得请求的参数username:"+username);
        System.out.println("获得请求的参数password:"+password);        
        // 2、封装User对象
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        // 3、调用服务类，完成用户名、密码的校验
        User u = userService.login(user);

        /*
         * 传统方式 if(u!=null){ //表示登录成功 request.setAttribute("user", user);
         * //跳转至首页... }else{ //登录失败，跳转登录页面
         * 
         * }
         */
        // ajax响应

        PrintWriter out = response.getWriter();

        

        if (u != null) {
            //0成功，1失败
            out.print(0);
        }else{
            out.print(1);
        }

         
       // out.print(0);
        
        out.close();

    }

}