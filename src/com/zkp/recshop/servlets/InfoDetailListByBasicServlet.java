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
import java.util.List;

/**
 *
 */
@WebServlet("/InfoDetailListByBasicServlet")
public class InfoDetailListByBasicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InfoDetailListByBasicServlet run success!");
        int basicInfoId = Integer.parseInt(req.getParameter("basicInfoId"));
        InfoDetailService infoDetailService = new InfoDetailService();
        List<InfoDetail> infoDetailList = infoDetailService.listInfoDetailByBasicInfoId(basicInfoId);
        ResultVO resultVO = infoDetailList==null?new ResultVO(1001,"fail"):new ResultVO(1000,"success",infoDetailList);
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
