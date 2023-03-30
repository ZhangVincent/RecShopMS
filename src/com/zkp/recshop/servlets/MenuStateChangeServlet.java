package com.zkp.recshop.servlets;

import com.zkp.recshop.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 控制第二类菜单的状态，接受更改状态的指令，并调用service实现
 */
@WebServlet("/MenuStateChangeServlet")
public class MenuStateChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MenuStateChangeServlet run success!");
        String menuCode = req.getParameter("menuCode");
        String oper = req.getParameter("oper");
        MenuService menuService = new MenuService();
        boolean done = false;
        if ("stop".equals(oper)) {
            done = menuService.disableMenu(menuCode);
        } else {
            done = menuService.enableMenu(menuCode);
        }
        String jsonStr = done ? "{\"code\":1000,\"msg\":\"success\"}" : "{\"code\":1001,\"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(jsonStr);
        writer.flush();
        writer.close();
    }
}
