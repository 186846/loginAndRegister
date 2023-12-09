package com.luli.demo.dao.Impl;

import com.luli.demo.dao.UserDao;
import com.luli.demo.entity.User;
import com.luli.demo.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class UserDaoImpl implements UserDao {
    public int add(User user) {
        // 定义影响行数
        int i = 0;
        // 定义连接为null
        Connection con = null;
        // 定义执行对象为null
        PreparedStatement ps = null;
        try {
            // 执行连接
            con = DBHelper.getcon();
            // 执行sql语句
            ps = con.prepareStatement("insert into user(username,password) values (?,?)");
            // 给占位符赋值
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
// 计算影响行数
            i = ps.executeUpdate();
            System.out.println("插入成功");
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, null);
        }
// 返回影响行数
        return i;
    }
    public int update(int id, User user) {
// 定义影响行数
        int i = 0;
// 定义连接为null
        Connection con = null;
// 定义执行对象为null
        PreparedStatement ps = null;
        try {
// 执行连接
            con = DBHelper.getcon();
// 执行sql语句
            ps = con.prepareStatement("update user set username=?,password=? where id="
                    + id);
// 给占位符赋值
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
// 计算影响行数
            i = ps.executeUpdate();
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, null);
        }
// 返回影响行数
        return i;
    }
    public int delete(User user) {
// 定义影响行数
        int i = 0;
// 定义连接为null
        Connection con = null;
// 定义执行对象为null
        PreparedStatement ps = null;
        try {
// 执行连接
            con = DBHelper.getcon();
// 执行sql语句
            ps = con.prepareStatement("delete from user where id=" + user.getId());
// 计算影响行数
            i = ps.executeUpdate();
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, null);
        }
// 返回影响行数
        return i;
    }
    public ArrayList<User> selAll() {
// 定义一个实体类集合
        ArrayList<User> list = new ArrayList<>();
// 定义连接为null
        Connection con = null;
// 定义执行对象为null
        PreparedStatement ps = null;
// 定义结果集为null
        ResultSet rs = null;
        try {
// 执行连接
            con = DBHelper.getcon();
// 执行sql语句
            ps = con.prepareStatement("select * from user");
// 执行结果集
            rs = ps.executeQuery();
// 遍历
            while (rs.next()) {
// 赋值
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
// 实例化对象赋值
                User user = new User(id, username, password);
// 添加
                list.add(user);
            }
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, rs);
        }
// 返回集合信息
        return list;
    }
    public User selbyId(User user) {
        User returnUser = null;
        Connection con = null;
// 定义执行对象为null
        PreparedStatement ps = null;
// 定义结果集为null
        ResultSet rs = null;
        try {
// 执行连接
            con = DBHelper.getcon();
// 执行sql语句
            ps = con.prepareStatement("select * from user where id=" + user.getId());
// 执行结果集
            rs = ps.executeQuery();
// 遍历
            if (rs.next()) {
                returnUser = new User();
                returnUser.setId(user.getId());
                returnUser.setUsername(rs.getString(2));
                returnUser.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, rs);
        }
// 返回实体类信息
        return returnUser;
    }
    public User selbyUsername(User user) {
        User returnUser = null;
        Connection con = null;
// 定义执行对象为null
        PreparedStatement ps = null;
// 定义结果集为null
        ResultSet rs = null;
        try {
// 执行连接
            con = DBHelper.getcon();
// 执行sql语句
            ps = con.prepareStatement("select * from user where username='" +
                    user.getUsername()+"'");
// 执行结果集
            rs = ps.executeQuery();
// 遍历
            if (rs.next()) {
                returnUser = new User();
                returnUser.setId(user.getId());
                returnUser.setUsername(rs.getString(2));
                returnUser.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
// TODO: handle exception
// 处理异常
            e.printStackTrace();
        } finally {
// 关闭资源
            DBHelper.getclose(con, ps, rs);
        }
// 返回实体类信息
        return returnUser;
    }
}
