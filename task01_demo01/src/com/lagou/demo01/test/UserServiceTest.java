package com.lagou.demo01.test;

import com.lagou.demo01.bean.Student;
import com.lagou.demo01.bean.User;
import com.lagou.demo01.dao.StudentDao;
import com.lagou.demo01.dao.StudentDaoImp;
import com.lagou.demo01.dao.UserDao;
import com.lagou.demo01.dao.UserDaoImp;
import com.lagou.demo01.service.StudentService;
import com.lagou.demo01.service.UserService;

import java.util.Date;
import java.util.List;

public class UserServiceTest {

    public static void main(String[] args) {

//        UserDao userDao = new UserDaoImp();
//        UserService userService = new UserService();
//        User admin = userService.userLoginService(new User("admin", "1234566"));
//        System.out.println("找到的数据为：" + admin);

        StudentDao studentDao = new StudentDaoImp();
        StudentService studentService = new StudentService();
//        List<Student> students=studentService.studentSelect(new Student());
//        System.out.println(students);

//        Student student=new Student("shibiqi","女",new Date(),"111@qq.com","备注");
//        studentService.studentAdd(student);
//        Student student=new Student(13,"aaa","女",new Date(),"111@qq.com","备注");
//        studentService.studentUpdate(student);

        studentService.studentDelete(12);
        List<Student> students=studentService.studentSelect(new Student());
        System.out.println(students);
    }
}
