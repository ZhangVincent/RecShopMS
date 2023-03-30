package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 品牌更新页面信息查询流程控制代码实现
 */
@WebServlet("/BrandQueryServlet")
public class BrandQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BrandQueryServlet run success!");
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        BrandService brandService = new BrandService();
        Brand brand = brandService.getBrandById(brandId);
        req.setAttribute("brand", brand);
        req.getRequestDispatcher("brand_modify.jsp").forward(req, resp);
    }
}
