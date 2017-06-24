package com.chd.dao;

import com.chd.domain.User;
import com.chd.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户Dao接口实现类
 */
public class UserDaoImpl implements UserDao{
    private Connection conn = DbUtil.getConnection();
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    /**
     * 注册用户的方法
     */
    public void regist(User user) throws SQLException {
        //数据库中保存数据
        String sql = "insert into user values (?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,user.getId());
        pstmt.setString(2,user.getUsername());
        pstmt.setString(3,user.getPassword());
        pstmt.setString(4,user.getNickname());
        pstmt.setString(5,user.getEmail());
        pstmt.setInt(6,user.getState());
        pstmt.setString(7,user.getCode());
        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public User getUserByCode(String code) throws SQLException {
        User user = null;

        String sql = "select * from user where code=?";
        pstmt =  conn.prepareStatement(sql);
        pstmt.setString(1,code);

        rs = pstmt.executeQuery();
        while(rs.next()) {
            user = new User();
            user.setId(rs.getInt("uid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            user.setState(rs.getInt("state"));
            user.setCode(rs.getString("code"));
        }

        rs.close();
        pstmt.close();
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "update user set username=?,password=?,nickname=?," +
                "email=?,state=?,code=? where uid=?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setString(3,user.getNickname());
        pstmt.setString(4,user.getEmail());
        pstmt.setInt(5,user.getState());
        pstmt.setString(6,user.getCode());
        pstmt.setInt(7,user.getId());

        pstmt.executeUpdate();
    }
}
