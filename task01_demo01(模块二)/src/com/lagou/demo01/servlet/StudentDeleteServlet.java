package com.lagou.demo01.servlet;

import com.lagou.demo01.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteServlet", urlPatterns = "/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int sid = Integer.parseInt(request.getParameter("deleteId"));

        //2. 执行删除
        StudentService studentService = new StudentService();
        studentService.studentDelete(sid);
        //3. 跳转到列表页。
        request.getRequestDispatcher("StudentListPageServlet").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
