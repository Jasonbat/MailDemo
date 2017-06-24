package com.chd.dao;

import com.chd.domain.User;

import java.sql.SQLException;

/**
 * 用户Dao接口
 */
public interface UserDao {
    void regist(User user) throws SQLException;

    User getUserByCode(String code) throws SQLException;

    void update(User user) throws SQLException;
}
