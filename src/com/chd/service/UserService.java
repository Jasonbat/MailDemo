package com.chd.service;

import com.chd.domain.User;

import java.sql.SQLException;

/**
 * 服务层接口
 */
public interface UserService {
    void regist(User user) throws Exception;

    User getUserByCode(String code) throws SQLException;

    void update(User user) throws SQLException;
}
