package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.service.BasicInfoService;
import com.zkp.recshop.utils.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 类目删除流程控制代码实现
 */
@WebServlet("/BasicInfoDeleteServlet")
public class BasicInfoDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoDeleteServlet run success!");
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        BasicInfoService basicInfoService = new BasicInfoService();
        boolean b = basicInfoService.deleteBasicInfoById(basicInfoId);
        ResultVO resultVO = b ? new ResultVO(1000, "success") : new ResultVO(1001, "fail");
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
