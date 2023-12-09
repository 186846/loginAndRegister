package com.luli.demo.factory;

import com.luli.demo.dao.Impl.UserDaoImpl;
import com.luli.demo.dao.UserDao;
public class DaoFactory {
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
