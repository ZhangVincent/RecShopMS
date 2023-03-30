package com.zkp.recshop.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码生成
 */

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 300;
        int height = 100;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D pen = image.createGraphics();
        pen.setColor(getRandomColor());
        pen.fillRect(0, 0, width, height);
        int letterNum = 4;
        int space = 20;
        int letterWidth = (width - (letterNum + 1) * space) / letterNum;
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < letterNum; i++) {
            int ascii = random.nextInt(26) + 97;
            String letter = new String(new byte[]{(byte) ascii});
            code.append(letter);
            pen.setColor(getRandomColor());
            pen.setFont(new Font("Gulim", Font.BOLD, 70));
            pen.drawString(letter, space + (letterWidth + space) * i, height - space);
        }
        HttpSession session = req.getSession();
        session.setAttribute("code", code.toString());
        ImageIO.write(image, "png", resp.getOutputStream());
        System.out.println("CheckCodeServlet run success!");
    }

    private Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        Color color = new Color(r, g, b);
        return color;
    }
}
