package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 根据管理员ID获得一级和二级菜单，返回至index.jsp页面
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IndexServlet run success!");
        MenuService menuService = new MenuService();
        HttpSession session = req.getSession();
        Manager mgr = (Manager) session.getAttribute("mgr");
        List<Menu1> menu1List = menuService.listMenusByMgrId(mgr.getMgrId());
        System.out.println(menu1List);
        req.setAttribute("menu1List",menu1List);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
