package com.hwua.web.servlet;

import com.hwua.entity.User;
import com.hwua.service.UserService;
import com.hwua.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// "/"代表 http://localhost:8080/虚拟目录名/lr.do
@WebServlet("/lr.do")
public class LoginRegisterServlet extends HttpServlet {
    private UserService us;

    @Override
    public void init(ServletConfig config) throws ServletException {
        us = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//处理post请求中文乱码问题
        String param = req.getParameter("param");
        if(param.equals("login")) {
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            try {
                user = us.login(user);//调用业务方法
                if (user == null) {
                    req.setAttribute("info", "用户名或密码错误");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    req.getRequestDispatcher("/msg.do?param=queryAllMsgs").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(param.equals("register")){
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            String email = req.getParameter("email");
            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setEmail(email);
            try {
                boolean flag = us.register(user);
                if(flag){
                    req.setAttribute("info","注册成功!");
                }else{
                    req.setAttribute("info","注册失败!");
                }
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
