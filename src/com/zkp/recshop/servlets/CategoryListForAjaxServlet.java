package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.dto.Category;
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
@WebServlet("/CategoryListForAjaxServlet")
public class CategoryListForAjaxServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CategoryListForAjaxServlet run success!");
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.listCategories();
        ResultVO resultVO = categoryList==null?new ResultVO(1001,"fail",null):new ResultVO(1000,"success",categoryList);
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
