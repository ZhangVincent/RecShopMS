package com.zkp.recshop.servlets;

import com.zkp.recshop.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 查询一级菜单和二级菜单，并送至admin_menu_list页面显示
 */
@WebServlet("/MenuListServlet")
public class MenuListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MenuListServlet run success!");
        MenuService menuService = new MenuService();
        Map<String, List> menus = menuService.listMenus();
        req.setAttribute("menu1List", menus.get("menu1List"));
        req.setAttribute("menu2List", menus.get("menu2List"));
        System.out.println(menus.get("menu1List"));
        req.getRequestDispatcher("admin_menu_list.jsp").forward(req, resp);
    }
}
