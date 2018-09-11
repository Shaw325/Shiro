package com.shaw.dao;

import com.shaw.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    public User getUser(@Param("name") String name);

    public List<User> getList();

    public User getUserWithLogin(@Param("user") User user);
}
