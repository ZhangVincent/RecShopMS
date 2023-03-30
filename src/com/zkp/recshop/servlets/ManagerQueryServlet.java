package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 管理员修改页面信息显示流程控制
 */
@WebServlet("/ManagerQueryServlet")
public class ManagerQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerQueryServlet run success!");
        String mgrId = req.getParameter("mgrId");
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.getManagerById(mgrId);
        String json = new Gson().toJson(manager);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
