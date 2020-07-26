package com.lagou.demo01.factory;

import com.lagou.demo01.dao.UserDao;
import com.lagou.demo01.dao.UserDaoImp;

public class UserDaoFactory {

    /**
     * 通过静态工程方法模式来实现UserDao实现类对象的创建并返回
     * @return
     */
    public static UserDao getUserDao() {
        return new UserDaoImp();
    }
}
