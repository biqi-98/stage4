package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.Student;
import com.lagou.demo01.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentEditServlet", urlPatterns = "/StudentEditServlet")
public class StudentEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int sid = Integer.parseInt(request.getParameter("sid"));

        //2. 查询学生数据
        StudentService service = new StudentService();
        Student stu = service.getStudentById(sid);

        //3. 显示数据
        //存数据
        request.setAttribute("stu", stu);
        //跳转
        request.getRequestDispatcher("student_save.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
