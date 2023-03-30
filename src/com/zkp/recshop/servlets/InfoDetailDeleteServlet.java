package com.zkp.recshop.servlets;

import com.google.gson.Gson;
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
 * 评估选项删除
 */
@WebServlet("/InfoDetailDeleteServlet")
public class InfoDetailDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InfoDetailDeleteServlet run success!");
        int infoDetailId = Integer.parseInt(req.getParameter("infoDetailId"));
        InfoDetailService infoDetailService = new InfoDetailService();
        boolean b = infoDetailService.deleteInfoDetail(infoDetailId);
        ResultVO resultVO = b?new ResultVO(1000,"success"):new ResultVO(1001,"fail");
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
