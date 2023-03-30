package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.dto.Role;
import com.zkp.recshop.service.ManagerService;
import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 管理员信息显示页面流程控制代码实现
 */
@WebServlet("/ManagerListServlet")
public class ManagerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerListServlet run success!");
        ManagerService managerService = new ManagerService();
        List<Manager> managerList = managerService.listManagers();
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.getRoles();
        req.setAttribute("managerList", managerList);
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_manager_list.jsp").forward(req, resp);
    }
}
