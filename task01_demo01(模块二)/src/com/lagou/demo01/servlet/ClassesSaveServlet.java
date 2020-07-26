package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.Classes;
import com.lagou.demo01.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassesSaveServlet", urlPatterns = "/ClassesSaveServlet")
public class ClassesSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("cid");
        int id = 0;
        if (cid != null && cid != "") {
            id = Integer.parseInt(cid);
        }
        String cname = request.getParameter("cname");
        String grand = request.getParameter("grand");
        String headmaster = request.getParameter("headmaster");
        String seat = request.getParameter("seat");
        String slogan = request.getParameter("slogan");
        //2. 添加到数据库
        Classes classes = new Classes(id, cname, grand, headmaster, seat, slogan);

        //2. 更新数据库数据
        ClassesService service = new ClassesService();
        if (classes.getId() != 0) {
            service.classesUpdate(classes);
        } else {
            service.classesAdd(classes);
        }
        //3. 跳转界面
        request.getRequestDispatcher("ClassesListPageServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
