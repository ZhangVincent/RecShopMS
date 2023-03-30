package com.zkp.recshop.servlets;

import com.google.gson.Gson;
import com.zkp.recshop.utils.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * 品牌显示流程控制代码实现
 */
@WebServlet("/ImageUploadServlet")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ImageUploadServlet run success!");
        Part part = req.getPart("brandLogoImg");
        String header = part.getHeader("Content-Disposition");
        String ext = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));
        String imageName = UUID.randomUUID().toString().replace("-", "") + ext;
        String dir = getServletContext().getRealPath("/brandImages");
        part.write(dir + "/" + imageName);
        String path = "brandImages/" + imageName;
        ResultVO resultVO = new ResultVO(1000, path);
        String json = new Gson().toJson(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
