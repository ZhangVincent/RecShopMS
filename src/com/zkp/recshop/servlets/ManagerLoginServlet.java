package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登录流程控制，效验验证码，用户名和密码，通过后转到index页面
 */

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerLoginServlet run success!");
        String loginName = req.getParameter("loginName");
        String loginPwd = req.getParameter("loginPwd");
        String loginCode = req.getParameter("loginCode");
        HttpSession session = req.getSession();
        if (loginCode.equals(session.getAttribute("code"))) {
            ManagerService managerService = new ManagerService();
            Manager manager = managerService.checkLogin(loginName, loginPwd);
            if (manager == null) {
                req.setAttribute("tips", "<label style='color:red'>登陆失败！账号或密码错误</label>");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                session.setAttribute("mgr", manager);
                resp.sendRedirect("IndexServlet");
            }
        } else {
            req.setAttribute("tips", "<label style='color:red'>验证码错误</label>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
