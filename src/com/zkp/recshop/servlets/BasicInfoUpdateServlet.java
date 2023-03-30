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
 * 类目更新流程控制代码实现
 */
@WebServlet("/BasicInfoUpdateServlet")
public class BasicInfoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoUpdateServlet run success!");
        req.setCharacterEncoding("utf-8");
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        String basicInfoName = req.getParameter("basicInfoName");
        int basicInfoStatus = Integer.parseInt(req.getParameter("basicInfoStatus"));
        BasicInfo basicInfo = new BasicInfo(basicInfoId, basicInfoName, basicInfoStatus);
        BasicInfoService basicInfoService = new BasicInfoService();
        boolean b = basicInfoService.updateBasicInfo(basicInfo);
        String tips = b?"类目更新成功！":"类目更新失败！";
        req.setAttribute("tips",tips);
        List<BasicInfo> basicInfoList = basicInfoService.listBasicInfos();
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("basic_info_list.jsp").forward(req, resp);
    }
}
