package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.dto.Category;
import com.zkp.recshop.service.BrandService;
import com.zkp.recshop.service.CategoryService;
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
 * 商品页面显示
 */
@WebServlet("/BrandListForAjaxServlet")
public class BrandListForAjaxServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BrandListForAjaxServlet run success!");
        BrandService brandService = new BrandService();
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        List<Brand> brandList = brandService.listBrandsByCategoryId(categoryId);
        ResultVO resultVO = brandList==null?new ResultVO(1001,"fail",null):new ResultVO(1000,"success",brandList);
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
