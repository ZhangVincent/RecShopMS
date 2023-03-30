package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Role;
import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 角色列表流程控制层代码实现
 */
@WebServlet("/RoleListServlet")
public class RoleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleListServlet run success!");
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.getRoles();
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_role_list.jsp").forward(req, resp);
    }
}
