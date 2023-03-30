package com.zkp.recshop.utils;


import com.zkp.recshop.dto.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器，对于受限资源的访问需要检查session是否已包含mgr信息
 * 如果不含mgr信息就转发至login页面
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        String path = url.substring(url.lastIndexOf("/") + 1);
        if ("login.jsp".equals(path) || "ManagerLoginServlet".equals(path) || "CheckCodeServlet".equals(path) || path.equals("") || path.endsWith(".js") || path.endsWith(".css") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".bmp") || path.endsWith(".woff2") || path.endsWith(".html")) {
            // 以上资源属于非受限资源
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            Manager manager = (Manager) session.getAttribute("mgr");
            if (manager == null) {
                request.setAttribute("tips", "<label style='color:red'>请先登录！</label>");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                if ("index.jsp".equals(path)) {
                    request.getRequestDispatcher("IndexServlet").forward(request, response);
                }
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        System.out.println("LoginFilter run success!");
    }

    @Override
    public void destroy() {

    }
}
