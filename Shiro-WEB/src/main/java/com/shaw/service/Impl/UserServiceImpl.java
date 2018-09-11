package com.shaw.service.Impl;

import com.shaw.dao.UserDao;
import com.shaw.pojo.User;
import com.shaw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/8/30 18:26
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    /**
     * 根据姓名查找用户
     * @param name
     * @return
     */
    @Override
    public User findUserByName(String name) {
        return userDao.getUser(name);
    }

    @Override
    public List<User> findAll() {
        return userDao.getList();
    }

    @Override
    public User findUserWithLogin(User user) {
        return userDao.getUserWithLogin(user);
    }
}
