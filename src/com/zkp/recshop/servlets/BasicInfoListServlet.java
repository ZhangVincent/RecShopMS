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
 * 类目显示流程控制代码实现
 */
@WebServlet("/BasicInfoListServlet")
public class BasicInfoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoListServlet run success!");
        BasicInfoService basicInfoService = new BasicInfoService();
        List<BasicInfo> basicInfoList = basicInfoService.listBasicInfos();
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("basic_info_list.jsp").forward(req, resp);
    }
}
