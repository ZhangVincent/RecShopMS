package com.zkp.recshop.servlets;

import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.service.BasicInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类目批量删除流程控制代码实现
 */
@WebServlet("/BasicInfoMultiDeleteServlet")
public class BasicInfoMultiDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BasicInfoMultiDeleteServlet run success!");
        String[] basicInfoIds = req.getParameterValues("basicInfoId");
        List<String> failIds = new ArrayList<>();
        BasicInfoService basicInfoService = new BasicInfoService();
        for (String id:basicInfoIds){
            boolean b = basicInfoService.deleteBasicInfoById(Integer.parseInt(id));
            if (!b){
                failIds.add(id);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:failIds){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        stringBuilder.append("删除失败！");
        String tips = failIds.size()==0?"多个类目删除成功":stringBuilder.toString();
        req.setAttribute("tips",tips);
        List<BasicInfo> basicInfoList = basicInfoService.listBasicInfos();
        req.setAttribute("basicInfoList", basicInfoList);
        req.getRequestDispatcher("basic_info_list.jsp").forward(req, resp);
    }
}
