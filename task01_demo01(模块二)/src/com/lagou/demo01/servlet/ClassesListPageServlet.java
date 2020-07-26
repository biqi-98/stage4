package com.lagou.demo01.servlet;

import com.lagou.demo01.bean.Classes;
import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassesListPageServlet", urlPatterns = "/ClassesListPageServlet")
public class ClassesListPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 获取需要显示的页码数
        String currentPageStr=request.getParameter("currentPage");
        int currentPage=1;
        if(currentPageStr!=null){
            currentPage=Integer.parseInt( currentPageStr);
        }

        //2. 根据指定的页数，去获取该页的数据回来
        Classes classes=new Classes();
        ClassesService classesService = new ClassesService();
        PageBean pageBean= classesService.getClassesListPage(classes,currentPage);
        request.setAttribute("pageBean", pageBean);
        //3. 跳转界面。
        request.getRequestDispatcher("classes_list_page.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
