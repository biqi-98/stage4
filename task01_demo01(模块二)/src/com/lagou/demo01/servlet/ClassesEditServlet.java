package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.Classes;
import com.lagou.demo01.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassesEditServlet", urlPatterns = "/ClassesEditServlet")
public class ClassesEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        int cid = Integer.parseInt(request.getParameter("cid"));

        //2. 查询学生数据
        ClassesService service = new ClassesService();
        Classes classes = service.getClassesById(cid);

        //3. 显示数据
        //存数据
        request.setAttribute("classes", classes);
        //跳转
        request.getRequestDispatcher("classes_save.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
