package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Goods;
import com.zkp.recshop.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品添加
 */
@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GoodsAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        String goodsName = req.getParameter("goodsName");
        String goodsImgPath = req.getParameter("goodsImgPath");
        int goodsCost = Integer.parseInt(req.getParameter("goodsCost"));
        int goodsMinPrice = Integer.parseInt(req.getParameter("goodsMinPrice"));
        String[] infoDetailIds = req.getParameterValues("infoDetailId");
        Goods goods = new Goods(0, goodsName, goodsImgPath, goodsCost, goodsMinPrice);
        GoodsService goodsService = new GoodsService();
        int goodsId = goodsService.saveGoods(goods, brandId);
        for (int i = 0; i < infoDetailIds.length; i++) {
            int infoDetailId = Integer.parseInt(infoDetailIds[i]);
            int price = Integer.parseInt(req.getParameter("price_" + infoDetailId));
            boolean b = goodsService.saveGoodsAndInfoDetail(goodsId, infoDetailId, price);
        }
        String tips = goodsId > 0 ? "<label style='color:green'>添加商品成功！</label>" : "<label style='color:red'>添加商品失败！</label>";
        req.setAttribute("tips", tips);
        req.getRequestDispatcher("products_list.jsp").forward(req, resp);
    }
}
