package com.yang;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class UserMapper implements RowMapper<UserLogin>{
    public UserLogin mapRow(ResultSet rs,int rowNum) throws SQLException {
        UserLogin user = new UserLogin();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
