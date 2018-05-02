package com.yang;

import java.util.List;
import javax.sql.DataSource;
public interface UserDAO {
    public void setDataSource(DataSource dataSource);

    public void adduser(String username, String password);

    public List<UserLogin> listusers();

    public Integer getuser(String username, String password);
}
