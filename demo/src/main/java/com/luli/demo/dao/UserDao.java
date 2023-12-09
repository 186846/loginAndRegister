package com.luli.demo.dao;

import com.luli.demo.entity.User;

import java.util.ArrayList;
public interface UserDao {
    public int add(User user);
    public int update(int id, User user);
    public int delete(User user);
    public ArrayList<User> selAll();
    public User selbyId(User user);
    public User selbyUsername(User user);
}
