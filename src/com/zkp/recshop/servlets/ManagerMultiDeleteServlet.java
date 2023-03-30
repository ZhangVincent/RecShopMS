package com.zkp.recshop.servlets;

import com.mysql.cj.util.StringUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * 批量删除管理员的流程控制代码实现
 */
@WebServlet("/ManagerMultiDeleteServlet")
public class ManagerMultiDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMultiDeleteServlet run success!");
        String[] mgrIds = req.getParameterValues("mgrId");
        List<String> failIds = new ArrayList<>();
        ManagerService managerService = new ManagerService();
        for (String mgrId:mgrIds){
            boolean deleteManager = managerService.deleteManager(mgrId);
            if (!deleteManager){
                failIds.add(mgrId);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:failIds){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        String tips = failIds.size()==0?"多个管理员删除成功！":stringBuilder.toString()+"删除失败！";
        req.setAttribute("tips",tips);
        List<Manager> managerList = managerService.listManagers();
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.getRoles();
        req.setAttribute("managerList", managerList);
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_manager_list.jsp").forward(req, resp);
    }
}
