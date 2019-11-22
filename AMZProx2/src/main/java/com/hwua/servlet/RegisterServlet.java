package com.hwua.servlet;

import com.hwua.dao.UserDao;
import com.hwua.daoimpl.UserDaoImpl;
import com.hwua.enpity.User;
import com.hwua.service.UserService;
import com.hwua.serviceimpl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rl.do")
public class RegisterServlet extends HttpServlet {
    private static UserService us;


    @Override
    public void init(ServletConfig config) throws ServletException {
        us=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.setCharacterEncoding("utf-8");
        String param = req.getParameter("param");
        if(param.equals("register")){
            String name = req.getParameter("userName");
            String pwd = req.getParameter("passWord");
            String sex = req.getParameter("sex");
            String birth = req.getParameter("birthday");
            String identity = req.getParameter("identity");
            String email = req.getParameter("email");
            String mobile = req.getParameter("mobile");
            String address = req.getParameter("address");
               User user=new User();
                user.setUname(name);
                user.setPwd(pwd);
                user.setSex(Integer.parseInt(sex));
                user.setBirthday(birth);
                user.setIdcard(identity);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setAddress(address);
           try {
                boolean flag = us.register(user);
                if(flag){
                    req.setAttribute("info","注册成功");
                    req.getRequestDispatcher("/reg-result.jsp").forward(req,resp);
                }else{
                    req.setAttribute("info","注册失败");
                    resp.sendRedirect(req.getContextPath()+"/register.jsp");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
