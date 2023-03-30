package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Category;
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
 * 删除多个分类流程控制代码实现
 */
@WebServlet("/CategoryMultiDeleteServlet")
public class CategoryMultiDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CategoryMultiDeleteServlet run success!");
        String[] categoryIds = req.getParameterValues("categoryId");
        List<String> failIds = new ArrayList<>();
        CategoryService categoryService = new CategoryService();
        for (String id:categoryIds){
            boolean b = categoryService.deleteCategory(Integer.parseInt(id));
            if (!b){
                failIds.add(id);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: failIds){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        String tips=failIds.size()==0?"多个分类删除成功！":stringBuilder.toString()+"删除失败！";
        req.setAttribute("tips",tips);
        List<Category> categoryList = categoryService.listCategories();
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("category_list.jsp").forward(req,resp);
    }
}
