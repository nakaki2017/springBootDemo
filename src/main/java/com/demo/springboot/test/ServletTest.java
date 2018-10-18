/**
 * 
 */
package com.demo.springboot.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 自定义 Servlet
 * @author lzq
 * @date 2018年4月4日 下午4:38:44
 */
public class ServletTest extends HttpServlet {
    private static final long serialVersionUID = -1927776419801730122L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("自定义 Servlet");
    }
    
}