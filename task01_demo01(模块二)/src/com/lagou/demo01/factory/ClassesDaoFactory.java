package com.lagou.demo01.factory;

import com.lagou.demo01.dao.ClassesDao;
import com.lagou.demo01.dao.ClassesDaoImp;

public class ClassesDaoFactory {

    /**
     * 通过静态工程方法模式来实现StudentDao实现类对象的创建并返回
     * @return
     */
    public static ClassesDao getClassesDao() {
        return new ClassesDaoImp();
    }
}
