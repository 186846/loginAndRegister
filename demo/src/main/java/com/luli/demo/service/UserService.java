package com.luli.demo.service;

import com.luli.demo.entity.User;
public interface UserService {
    public boolean login(User user);
    public boolean register(User user);
}
