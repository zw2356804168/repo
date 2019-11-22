package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.User;
import com.hwua.service.UserService;
import com.hwua.serviceimpl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/lr.do")
public class LoginServlet extends HttpServlet {
    private UserService userService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        userService=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    //登录
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=ytf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String param = req.getParameter("param");
        //登录
        if(param.equals("logn")){
            Map<String ,Object>map=new HashMap();
            String name = req.getParameter("userName");
            String pwd = req.getParameter("passWord");
            User user = new User(name,pwd);
            try {
                User login = userService.login(user);
                if(login == null){
                    map.put("info","用户名密码错误");
                    map.put("success",false);
                }else{
                    session.setAttribute("login",login);
                    map.put("success",true);
                    map.put("info","");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            String s = JSON.toJSONString(map);
             out.print(s);
        }


        /*String name = req.getParameter("userName");
            String pwd = req.getParameter("passWord");
            User user = new User(name,pwd);
            try {
                User login = userService.login(user);
                if (login == null) {
                    req.setAttribute("info", "用户名或密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else {

                   // HttpSession session = req.getSession();
                    session.setAttribute("login", login);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
                } catch(Exception e){
                   e.printStackTrace();
                }*/
           }

    }


