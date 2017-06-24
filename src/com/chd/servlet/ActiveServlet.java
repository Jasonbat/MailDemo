package com.chd.servlet;

import com.chd.domain.User;
import com.chd.service.UserService;
import com.chd.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户激活servlet
 */
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //获取激活码
            String code = request.getParameter("code");

            UserService userService = new UserServiceImpl();
            User user = userService.getUserByCode(code);

            if (user != null) {
                user.setCode(null);
                user.setState(1); //1.已经激活
                userService.update(user); //更新用户
                //页面跳转
                request.setAttribute("msg", "您应激活成功，可以登录了");
            } else {
                request.setAttribute("msg", "您的激活码有误");
            }

            request.getRequestDispatcher("msg.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
