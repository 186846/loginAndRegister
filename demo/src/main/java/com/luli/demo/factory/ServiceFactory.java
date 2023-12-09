package com.luli.demo.factory;

import com.luli.demo.service.Impl.UserServiceImpl;
import com.luli.demo.service.UserService;
public class ServiceFactory {
    public static UserService createUserService() {
        return new UserServiceImpl();
    }
}
