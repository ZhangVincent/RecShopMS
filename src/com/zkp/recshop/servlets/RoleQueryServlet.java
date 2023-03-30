package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.dto.Menu2;
import com.zkp.recshop.dto.Role;
import com.zkp.recshop.service.MenuService;
import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 角色信息修改页面显示流程控制代码实现
 */
@WebServlet("/RoleQueryServlet")
public class RoleQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleQueryServlet run success!");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        RoleService roleService = new RoleService();
        Role role = roleService.getRoleById(roleId);
        List<Integer> menuIds = roleService.getMenuIdsByRoleId(roleId);
        MenuService menuService = new MenuService();
        List<Menu1> menu1List = menuService.listAllMenus();
        for (Menu1 menu1 : menu1List) {
            if (menuIds.contains(menu1.getMenuId())) {
                menu1.setHaveMenu(true);
            }
            for (Menu2 menu2 : menu1.getChildMenus()) {
                if (menuIds.contains(menu2.getMenuId())) {
                    menu2.setHaveMenu(true);
                }
            }
        }
        req.setAttribute("role", role);
        req.setAttribute("menu1List", menu1List);
        req.getRequestDispatcher("admin_role_modify.jsp").forward(req, resp);
    }
}
