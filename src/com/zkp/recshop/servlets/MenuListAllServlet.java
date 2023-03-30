package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有一级菜单，并将信息传递给admin_role_list.jsp
 */
@WebServlet("/MenuListAllServlet")
public class MenuListAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MenuListAllServlet run success！");
        MenuService menuService = new MenuService();
        List<Menu1> menu1List = menuService.listAllMenus();
        req.setAttribute("menu1List", menu1List);
        req.getRequestDispatcher("admin_role_add.jsp").forward(req, resp);
    }
}
