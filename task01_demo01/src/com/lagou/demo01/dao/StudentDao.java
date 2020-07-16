package com.lagou.demo01.dao;

import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Student;

import java.util.List;

public interface StudentDao {
    // 自定义抽象方法描述添加学生的实现
    public abstract void studentAdd(Student student);

    // 自定义抽象方法描述修改学生的实现
    public abstract void studentUpdate(Student student);

    // 自定义抽象方法描述删除学生的实现
    public abstract void studentDelete(Integer id);

    // 自定义抽象方法描述查询学生的实现
    public abstract List<Student> studentSelect(Student student);

    // 自定义抽象方法描述根据id查找学生的实现
    public abstract Student getStudentById(Integer id);

    // 自定义抽象方法描述查找学生分页
    public abstract List<Student> getStudentListPage(Student student,PageBean pageBean);

    // 自定义抽象方法描述查找学生数量
    public abstract int findCount(Student student);
}
