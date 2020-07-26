package com.lagou.demo01.service;

import com.lagou.demo01.bean.Classes;
import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.dao.ClassesDao;
import com.lagou.demo01.factory.ClassesDaoFactory;

import java.util.List;

public class ClassesService {
    private ClassesDao classesDao;

    public ClassesService() {
        this.classesDao = ClassesDaoFactory.getClassesDao();
    }

    /**
     * 自定义成员方法实现Classes添加
     *
     * @param classes
     * @return
     */
    public void classesAdd(Classes classes) {
        classesDao.classesAdd(classes);
    }

    /**
     * 自定义成员方法实现Classes修改
     *
     * @param classes
     * @return
     */
    public void classesUpdate(Classes classes) {
        classesDao.classesUpdate(classes);
    }

    /**
     * 自定义成员方法实现Classes删除
     *
     * @param id
     * @return
     */
    public void classesDelete(Integer id) {
        classesDao.classesDelete(id);
    }

    /**
     * 自定义成员方法实现Classes查询
     *
     * @param classes
     * @return
     */
    public List<Classes> classesSelect(Classes classes) {
        return classesDao.classesSelect(classes);
    }

    /**
     * 自定义成员方法实现Classes分页查询
     *
     * @param classes
     * @return
     */
    public PageBean getClassesListPage(Classes classes, int currentPage) {
        PageBean<Classes> pageBean = new PageBean<Classes>();

        int pageSize = 10;
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设置每页显示多少记录

        List<Classes> list = classesDao.getClassesListPage(classes, pageBean);
        pageBean.setList(list); //设置这一页的学生数据

        //总的记录数， 总的页数。
        int count = classesDao.findCount(classes);
        pageBean.setTotalSize(count); //设置总的记录数
        //200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1); //总页数
        return pageBean;
    }

    /**
     * 自定义成员方法实现Classes id查询
     *
     * @param id
     * @return
     */
    public Classes getClassesById(Integer id){
        return classesDao.getClassesById(id);
    }
}

