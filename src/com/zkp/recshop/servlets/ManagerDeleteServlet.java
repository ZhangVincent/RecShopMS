package com.zkp.recshop.servlets;

import com.zkp.recshop.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 删除管理员流程控制
 */
@WebServlet("/ManagerDeleteServlet")
public class ManagerDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerDeleteServlet run success!");
        String mgrId = req.getParameter("mgrId");
        ManagerService managerService = new ManagerService();
        boolean deleteManager = managerService.deleteManager(mgrId);
        String jsonStr = deleteManager ? "{\"code\":1000,\"msg\":\"success\"}" : "{\"code\":1001,\"msg\":\"fail\"}";
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
