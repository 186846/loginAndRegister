package com.luli.demo.controller;

import com.luli.demo.entity.User;
import com.luli.demo.factory.ServiceFactory;
import com.luli.demo.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login",value = "/checklogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");//控制器获得从视图请求发来的参数值
        String password = req.getParameter("password");
        User user = new User();//实体类对象，VO，
        user.setUsername(username);
        user.setPassword(password);
        UserService userService = ServiceFactory.createUserService();//获得业务组件对象
        boolean result = userService.login(user); //执行登录检查，判断user是否是一个合法登录用户
//控制器进行视图的切换
        System.out.println(result);
        if(result){//登录成功
            RequestDispatcher rd = this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);//服务器端跳转，跳转到登录成功页
        }else{//登录失败
            resp.sendRedirect("/login.html");//跳转到登录页
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }
}