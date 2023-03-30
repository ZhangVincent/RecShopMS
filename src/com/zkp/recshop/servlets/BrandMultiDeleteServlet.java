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
import java.util.ArrayList;
import java.util.List;

/**
 * 品牌批量删除流程控制代码实现
 */
@WebServlet("/BrandMultiDeleteServlet")
public class BrandMultiDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BrandMultiDeleteServlet run success!");
        String[] brandIds = req.getParameterValues("brandId");
        List<String> failIds = new ArrayList<>();
        BrandService brandService = new BrandService();
        for (String brandId:brandIds){
            boolean b = brandService.deleteBrandById(Integer.parseInt(brandId));
            if (!b){
                failIds.add(brandId);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:failIds){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        stringBuilder.append("删除失败！");
        String tips = failIds.size()==0?"多个品牌删除成功":stringBuilder.toString();
        req.setAttribute("tips",tips);
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.listCategories();
        int cid = categoryList.get(0).getCategoryId();
        List<Brand> brandList = brandService.listBrandsByCategoryId(cid);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("cid", cid);
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("brand_list.jsp").forward(req,resp);
    }
}
