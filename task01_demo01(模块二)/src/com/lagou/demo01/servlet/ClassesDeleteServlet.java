package com.lagou.demo01.servlet;

import com.lagou.demo01.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassesDeleteServlet", urlPatterns = "/ClassesDeleteServlet")
public class ClassesDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int cid = Integer.parseInt(request.getParameter("deleteId"));

        //2. 执行删除
        ClassesService classesService = new ClassesService();
        classesService.classesDelete(cid);
        //3. 跳转到列表页。
        request.getRequestDispatcher("ClassesListPageServlet").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
