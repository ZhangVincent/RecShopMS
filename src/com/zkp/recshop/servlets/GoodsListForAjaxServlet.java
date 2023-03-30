package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.Goods;
import com.zkp.recshop.service.GoodsService;
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
 * 商品显示
 */
@WebServlet("/GoodsListForAjaxServlet")
public class GoodsListForAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GoodsListForAjaxServlet run success!");
        GoodsService goodsService = new GoodsService();
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        List<Goods> goodsList =goodsService.selectGoodsByBrandId(brandId);
        ResultVO resultVO = goodsList==null?new ResultVO(1001,"fail",null):new ResultVO(1000,"success",goodsList);
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
