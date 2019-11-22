package com.hwua.web.servlet;

import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.MsgService;
import com.hwua.service.UserService;
import com.hwua.service.impl.MsgServiceImpl;
import com.hwua.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/msg.do")
public class MsgServlet extends HttpServlet {
    private MsgService msgService;
    private UserService us;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.msgService = new MsgServiceImpl();//创建业务层对象
        us = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String param = req.getParameter("param");
        if (param.equals("queryAllMsgs")) {
            //获取session中保存的登录用户信息
            HttpSession session = req.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("user");
                try {
                    List<Message> msgs = msgService.queryAllMsgsByLoginId(user.getId());
                    req.setAttribute("msgs", msgs);//把业务层返回的数据放到request域中
                    //转发
                    req.getRequestDispatcher("/main.jsp").forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (param.equals("queryMsgById")) {
            String id = req.getParameter("id");
            try {
                Message msg = msgService.queryMsgById(Long.parseLong(id));
                Long sendid = msg.getSendid();
                //得到发送者对象
                User sendUser = us.querySendUserById(sendid);
                //把对象封装到Message对象中
                msg.setSendUser(sendUser);
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/readMsg.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (param.equals("delMsg")) {
            String id = req.getParameter("id");
            try {
                int res = msgService.delMsgById(id);
                if (res > 0) {
                    req.getRequestDispatcher("/msg.do?param=queryAllMsgs").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
