package com.zkp.recshop.servlets;

import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 角色删除操作
 */
@WebServlet("/RoleDeleteServlet")
public class RoleDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleDeleteServlet run success!");
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        RoleService roleService = new RoleService();
        boolean deleteRole = roleService.deleteRole(roleId);
        String str = deleteRole ? "{\"code\":1000,\"msg\":\"success\"}":"{\"code\":1001,\"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
