package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Role;
import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 角色信息修改流程控制代码
 */
@WebServlet("/RoleUpdateServlet")
public class RoleUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleUpdateServlet run success!");
        req.setCharacterEncoding("utf-8");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        Role role = new Role(roleId, roleName, roleDesc);
        String[] menuIds = req.getParameterValues("menuId");
        RoleService roleService = new RoleService();
        boolean updateRole = roleService.updateRole(role, menuIds);
        String tips = updateRole ? "<label style='color:green'>修改角色信息成功！</label>" : "<label style='color:red'>修改角色信息失败！</label>";
        req.setAttribute("tips", tips);
        req.getRequestDispatcher("prompt.jsp").forward(req, resp);
    }
}
