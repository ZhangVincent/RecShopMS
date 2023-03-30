package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.InfoDetail;
import com.zkp.recshop.service.InfoDetailService;
import com.zkp.recshop.utils.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 新增评估选项
 */
@WebServlet("/InfoDetailAddServlet")
public class InfoDetailAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InfoDetailAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        String infoDetailName = req.getParameter("infoDetailName");
        String infoDetailDesc = req.getParameter("infoDetailDesc");
        InfoDetail infoDetail = new InfoDetail(0, infoDetailName, infoDetailDesc, basicInfoId);
        InfoDetailService infoDetailService = new InfoDetailService();
        boolean b = infoDetailService.saveInfoDetail(infoDetail);
        ResultVO resultVO = b?new ResultVO(1000,"success"):new ResultVO(1001,"fail");
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
