package com.lagou.demo01.factory;

import com.lagou.demo01.dao.StudentDao;
import com.lagou.demo01.dao.StudentDaoImp;
import com.lagou.demo01.dao.UserDao;
import com.lagou.demo01.dao.UserDaoImp;

public class StudentDaoFactory {

    /**
     * 通过静态工程方法模式来实现StudentDao实现类对象的创建并返回
     * @return
     */
    public static StudentDao getStudentDao() {
        return new StudentDaoImp();
    }
}
