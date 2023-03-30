package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.dto.Category;
import com.zkp.recshop.service.BrandService;
import com.zkp.recshop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 品牌显示流程控制代码实现
 */
@WebServlet("/BrandListServlet")
public class BrandListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BrandListServlet run success!");
        String categoryId = req.getParameter("categoryId");
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.listCategories();
        int cid = categoryId == null ? categoryList.get(0).getCategoryId() : Integer.parseInt(categoryId);
        BrandService brandService = new BrandService();
        List<Brand> brandList = brandService.listBrandsByCategoryId(cid);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("cid", cid);
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("brand_list.jsp").forward(req, resp);
    }
}
