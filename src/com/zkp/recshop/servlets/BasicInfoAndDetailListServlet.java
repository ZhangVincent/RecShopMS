package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.dto.InfoDetail;
import com.zkp.recshop.service.BasicInfoService;
import com.zkp.recshop.service.InfoDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 商品添加流程控制代码实现
 */
@WebServlet("/BasicInfoAndDetailListServlet")
public class BasicInfoAndDetailListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoAndDetailListServlet run success!");
        BasicInfoService basicInfoService = new BasicInfoService();
        InfoDetailService infoDetailService = new InfoDetailService();
        List<BasicInfo> basicInfoList = basicInfoService.listBasicInfos();
        for (int i = 0; i < basicInfoList.size(); i++) {
            BasicInfo basicInfo = basicInfoList.get(i);
            List<InfoDetail> infoDetailList = infoDetailService.listInfoDetailByBasicInfoId(basicInfo.getBasicInfoId());
            basicInfo.setInfoDetailList(infoDetailList);
        }
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("products_add.jsp").forward(req, resp);
    }
}
