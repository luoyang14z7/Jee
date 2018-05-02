package com.yang;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public void adduser(String username, String password) {
        String SQL = "insert into users(username,password) value(?,?)";
        jdbcTemplateObject.update(SQL, username, password);
        return;
    }

    public List<UserLogin> listusers() {
        String SQL = "select * from users";
        List<UserLogin> users = jdbcTemplateObject.query(SQL, new UserMapper());
    return users;
    }

    public Integer getuser(String username,String password){
        String SQL = "SELECT count(*) FROM USERS WHERE username=? AND password=?";
        Integer getuser = jdbcTemplateObject.queryForObject(SQL,new Object[]{username, password},Integer.class);
        return getuser;
    }



}
