package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Category;
import com.zkp.recshop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 分类显示流程控制代码实现
 */
@WebServlet("/CategoryListServlet")
public class CategoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CategoryListServlet run success!");
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.listCategories();
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("category_list.jsp").forward(req,resp);
    }
}
