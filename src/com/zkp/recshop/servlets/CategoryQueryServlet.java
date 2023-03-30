package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Category;
import com.zkp.recshop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分类显示流程控制代码实现
 */
@WebServlet("/CategoryQueryServlet")
public class CategoryQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CategoryQueryServlet run success!");
        String cid  =req.getParameter("categoryId");
        int categoryId = Integer.parseInt(cid);
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.getCategoryById(categoryId);
        req.setAttribute("category", category);
        req.getRequestDispatcher("category_modify.jsp").forward(req, resp);
    }
}
