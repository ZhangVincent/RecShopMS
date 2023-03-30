package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.service.BasicInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类目更新页面信息查询流程控制代码实现
 */
@WebServlet("/BasicInfoQueryServlet")
public class BasicInfoQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoQueryServlet run success!");
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        BasicInfoService basicInfoService = new BasicInfoService();
        BasicInfo basicInfo = basicInfoService.getBasicInfoById(basicInfoId);
        req.setAttribute("basicInfo",basicInfo);
        req.getRequestDispatcher("basic_info_modify.jsp").forward(req,resp);
    }
}
