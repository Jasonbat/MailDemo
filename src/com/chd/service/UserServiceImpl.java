package com.chd.service;

import com.chd.dao.UserDao;
import com.chd.dao.UserDaoImpl;
import com.chd.domain.User;
import com.chd.utils.MailUtil;

import java.sql.SQLException;

/**
 * 用户服务层接口实现类
 */
public class UserServiceImpl implements UserService{
    @Override
    public void regist(User user) throws Exception {
        //将数据存放到数据库
        UserDao userDao = new UserDaoImpl();
        userDao.regist(user);

        //发送激活邮件
        MailUtil.sendMail(user.getEmail(),user.getCode());
    }

    @Override
    public User getUserByCode(String code) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByCode(code);
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }
}
