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
 * 保存提交的角色信息
 */
@WebServlet("/RoleAddServlet")
public class RoleAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        RoleService roleService = new RoleService();
        String roleName = req.getParameter("roleName");
        String roleDesc = req.getParameter("roleDesc");
        Role role = new Role(0, roleName, roleDesc);
        String[] menuIds = req.getParameterValues("menuId");
        boolean b = roleService.addRole(role, menuIds);
        String tips = b ? "<label style='color:green'>添加⻆⾊信息成功！</label>" : "<label style='color:red'>添加⻆⾊信息失败！</label>";
        req.setAttribute("tips", tips);
        req.getRequestDispatcher("prompt.jsp").forward(req, resp);
    }
}
