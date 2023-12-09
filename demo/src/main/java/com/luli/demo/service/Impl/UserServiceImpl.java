package com.luli.demo.service.Impl;

import com.luli.demo.dao.UserDao;
import com.luli.demo.entity.User;
import com.luli.demo.factory.DaoFactory;
import com.luli.demo.service.UserService;
public class UserServiceImpl implements UserService {
    public boolean login(User user) {
        boolean result = false;
        UserDao userDao = DaoFactory.createUserDao();
        User returnUser = userDao.selbyUsername(user);
        if(returnUser == null)
            return false;

        if(returnUser.getPassword().equals(user.getPassword()))
            result = true;
        return result;
    }

    @Override
    public boolean register(User user) {
        boolean result =false;
        UserDao userDao = DaoFactory.createUserDao();
        User returnUser = userDao.selbyUsername(user);
        if(returnUser == null){
            userDao.add(user);
            result = true;
        }
        return result;
    }
}
