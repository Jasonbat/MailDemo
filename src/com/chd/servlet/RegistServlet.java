package com.chd.servlet;

import com.chd.domain.User;
import com.chd.service.UserService;
import com.chd.service.UserServiceImpl;
import com.chd.utils.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //处理中文乱码
            request.setCharacterEncoding("utf-8");

            //接收参数
            String username = request.getParameter("username");
            String password  = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setEmail(email);

            user.setState(0);  //状态： 0-未激活   1-已激活
            //uuid产生的是32位的随机字符串，这里的code是64位的
            user.setCode(UUIDUtil.getUUID()+UUIDUtil.getUUID());
            UserService userService = new UserServiceImpl();

            userService.regist(user);

            //页面跳转
            request.setAttribute("msg","您已经成功注册用户，请到邮箱中激活");

            request.getRequestDispatcher("msg.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
