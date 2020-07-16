package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.Student;
import com.lagou.demo01.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SaveServlet", urlPatterns = "/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String sid = request.getParameter("sid");
        int id = 0;
        if (sid != null && sid != "") {
            id = Integer.parseInt(sid);
        }
        String sname = request.getParameter("sname");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String remark = request.getParameter("remark");
        //2. 添加到数据库
        //string -- date
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(id, sname, sex, date, email, remark);

        //2. 更新数据库数据
        StudentService service = new StudentService();
        if (student.getId() != 0) {
            service.studentUpdate(student);
        } else {
            service.studentAdd(student);
        }
        //3. 跳转界面
        request.getRequestDispatcher("StudentListPageServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
