package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.Category;
import com.zkp.recshop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 分类显示流程控制代码实现
 */
@WebServlet("/CategoryAddServlet")
@MultipartConfig
public class CategoryAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CategoryAddServlet run success!");
        req.setCharacterEncoding("utf-8");
        String categoryName = req.getParameter("categoryName");
        Part part = req.getPart("categoryIcon");
        String header = part.getHeader("Content-Disposition");
        String ext = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));
        String iconName = UUID.randomUUID().toString().replace("-", "") + ext;
        String dir = getServletContext().getRealPath("/categoryImages");
        System.out.println(dir + "/" + iconName);
        part.write(dir + "/" + iconName);
        Category category = new Category(0, categoryName, "categoryImages/" + iconName, "1");
        CategoryService categoryService = new CategoryService();
        boolean b = categoryService.saveCategory(category);
        String tips = b ? "<label style='color:green'>添加分类成功！</label>" : "<label style='color:red'>添加分类失败！</label>";
        req.setAttribute("tips", tips);
        List<Category> categoryList = categoryService.listCategories();
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("category_list.jsp").forward(req, resp);
    }
}
