package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.service.BasicInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 类目新增流程控制代码实现
 */
@WebServlet("/BasicInfoAddServlet")
public class BasicInfoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        String basicInfoName = req.getParameter("basicInfoName");
        BasicInfo basicInfo = new BasicInfo(0, basicInfoName, 1);
        BasicInfoService basicInfoService = new BasicInfoService();
        boolean b = basicInfoService.saveBasicInfo(basicInfo);
        String tips = b?"类目添加成功！":"类目添加失败！";
        req.setAttribute("tips",tips);
        List<BasicInfo> basicInfoList = basicInfoService.listBasicInfos();
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("basic_info_list.jsp").forward(req, resp);
    }
}
