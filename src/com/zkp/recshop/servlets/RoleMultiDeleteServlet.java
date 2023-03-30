package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Role;
import com.zkp.recshop.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 进行角色的批量删除操作
 */
@WebServlet("/RoleMultiDeleteServlet")
public class RoleMultiDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RoleMultiDeleteServlet run success!");
        String[] roleIds = req.getParameterValues("roleId");
        RoleService roleService = new RoleService();
        List<String> failIds = new ArrayList<>();
        for (String roleId : roleIds) {
            boolean deleteRole = roleService.deleteRole(Integer.parseInt(roleId));
            if (!deleteRole) {
                failIds.add(roleId);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : failIds) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        stringBuilder.append("删除失败！");
        String tips = failIds.size() == 0 ? "删除成功！" : stringBuilder.toString();
        req.setAttribute("tips", tips);
        List<Role> roleList = roleService.getRoles();
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_role_list.jsp").forward(req, resp);
    }
}
