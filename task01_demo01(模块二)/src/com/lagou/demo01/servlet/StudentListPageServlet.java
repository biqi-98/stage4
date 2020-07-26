package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Student;
import com.lagou.demo01.dao.StudentDao;
import com.lagou.demo01.dao.StudentDaoImp;
import com.lagou.demo01.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentListPageServlet", urlPatterns = "/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 获取需要显示的页码数
        String currentPageStr=request.getParameter("currentPage");
        int currentPage=1;
        if(currentPageStr!=null){
            currentPage=Integer.parseInt( currentPageStr);
        }

        //2. 根据指定的页数，去获取该页的数据回来
        Student student=new Student();
        String sid=request.getParameter("sid");
        if(sid!=null&&sid!=""){
            student.setId(Integer.parseInt(sid));
        }
        String sname=request.getParameter("sname");
        if(sname!=null&&sname!=""){
            student.setName(sname);
        }

        StudentService studentService = new StudentService();
        PageBean pageBean= studentService.getStudentListPage(student,currentPage);
        request.setAttribute("pageBean", pageBean);
        //3. 跳转界面。
        request.getRequestDispatcher("student_list_page.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
