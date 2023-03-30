package com.zkp.recshop.servlets;

import com.zkp.recshop.dao.ManagerDAO;
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
import java.util.Date;
import java.util.List;

/**
 * 管理员添加流程控制代码实现
 */
@WebServlet("/ManagerAddServlet")
public class ManagerAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        String mgrId = req.getParameter("mgrId");
        String loginName = req.getParameter("loginName");
        String loginPwd = req.getParameter("loginPwd");
        String mgrName = req.getParameter("mgrName");
        String mgrGender = req.getParameter("mgrGender");
        String mgrTel = req.getParameter("mgrTel");
        String mgrEmail = req.getParameter("mgrEmail");
        String mgrQQ = req.getParameter("mgrQQ");
        Manager manager = new Manager(mgrId, loginName, loginPwd, mgrName, mgrGender, mgrTel, mgrEmail, mgrQQ, new Date());
        int roleId = Integer.parseInt(req.getParameter("roleId"));
        ManagerService managerService = new ManagerService();
        boolean saveManager = managerService.saveManager(manager, roleId);
        String tips = saveManager?"<label style='color:green'>管理员添加成功！</label>":"<label style='color:red'>管理员添加失败！</label>";
        req.setAttribute("tips",tips);

        List<Manager> managerList = managerService.listManagers();
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.getRoles();
        req.setAttribute("managerList", managerList);
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("admin_manager_list.jsp").forward(req, resp);
    }
}
