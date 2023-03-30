package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.Menu2;
import com.zkp.recshop.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 接受Ajax请求，根据一级菜单输出对应的二级菜单，以json的形式返回
 */
@WebServlet("/Menu2ListByMenu1Servlet")
public class Menu2ListByMenu1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Menu2ListByMenu1Servlet run success!");
        String parentCode = req.getParameter("parentCode");
        MenuService menuService = new MenuService();
        List<Menu2> menu2List = menuService.listMenu2ByMenu1Code(parentCode);

        Gson gson = new Gson();
        System.out.println(menu2List);
        String jsonStr = gson.toJson(menu2List);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
