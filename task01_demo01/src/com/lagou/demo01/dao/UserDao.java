package com.lagou.demo01.dao;

import com.lagou.demo01.bean.User;

public interface UserDao {
    // 自定义抽象方法描述登录功能的实现
    public abstract User userLogin(User user);
}
