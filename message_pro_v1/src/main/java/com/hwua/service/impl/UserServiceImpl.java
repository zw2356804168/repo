package com.hwua.service.impl;

import com.hwua.dao.UserDao;
import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(User user) throws Exception {
        return userDao.queryByUser(user);
    }

    @Override
    public boolean register(User user) throws Exception {
        return userDao.insert(user) == 1 ? true : false;
    }

    @Override
    public User querySendUserById(Long sendId) throws Exception {
        return userDao.queryById(sendId);
    }
}
