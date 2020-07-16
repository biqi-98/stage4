package com.lagou.demo01.service;

import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Student;
import com.lagou.demo01.bean.User;
import com.lagou.demo01.dao.StudentDao;
import com.lagou.demo01.dao.UserDao;
import com.lagou.demo01.factory.StudentDaoFactory;
import com.lagou.demo01.factory.UserDaoFactory;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = StudentDaoFactory.getStudentDao();
    }

    /**
     * 自定义成员方法实现Student添加
     *
     * @param student
     * @return
     */
    public void studentAdd(Student student) {
        studentDao.studentAdd(student);
    }

    /**
     * 自定义成员方法实现Student修改
     *
     * @param student
     * @return
     */
    public void studentUpdate(Student student) {
        studentDao.studentUpdate(student);
    }

    /**
     * 自定义成员方法实现Student删除
     *
     * @param id
     * @return
     */
    public void studentDelete(Integer id) {
        studentDao.studentDelete(id);
    }

    /**
     * 自定义成员方法实现Student查询
     *
     * @param student
     * @return
     */
    public List<Student> studentSelect(Student student) {
        return studentDao.studentSelect(student);
    }

    /**
     * 自定义成员方法实现Student分页查询
     *
     * @param student
     * @return
     */
    public PageBean getStudentListPage(Student student, int currentPage) {
        PageBean<Student> pageBean = new PageBean<Student>();

        int pageSize = 10;
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设置每页显示多少记录

        List<Student> list = studentDao.getStudentListPage(student, pageBean);
        pageBean.setList(list); //设置这一页的学生数据

        //总的记录数， 总的页数。
        int count = studentDao.findCount(student);
        pageBean.setTotalSize(count); //设置总的记录数
        //200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1); //总页数
        return pageBean;
    }

    /**
     * 自定义成员方法实现Student id查询
     *
     * @param id
     * @return
     */
    public Student getStudentById(Integer id){
        return studentDao.getStudentById(id);
    }
}

