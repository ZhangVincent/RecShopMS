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
import java.util.Date;
import java.util.List;

/**
 * 品牌更新流程控制代码实现
 */
@WebServlet("/BrandUpdateServlet")
public class BrandUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BrandUpdateServlet run success!");
        req.setCharacterEncoding("utf-8");
        int brandId = Integer.parseInt(req.getParameter("brandId"));
        String brandName = req.getParameter("brandName");
        String brandLogoPath = req.getParameter("brandLogoPath");
        String brandDesc = req.getParameter("brandDesc");
        int brandStatus = Integer.parseInt(req.getParameter("brandStatus"));
        Brand brand = new Brand(brandId, brandName, brandLogoPath, brandDesc, new Date(), brandStatus);
        BrandService brandService = new BrandService();
        boolean b = brandService.updateBrand(brand);
        String tips = b ? "<label style='color:green'>品牌修改成功！</label>" : "<label style='color:red'>品牌修改失败！</label>";
        req.setAttribute("tips", tips);

        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.listCategories();
        int cid = categoryList.get(0).getCategoryId();
        List<Brand> brandList = brandService.listBrandsByCategoryId(cid);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("cid", cid);
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("brand_list.jsp").forward(req, resp);
    }
}
