/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package project.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.business.Product;
import project.data.UserDB;

/**
 *
 * @author nguye
 */
public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCategory = request.getParameter("productCategory");
        
        // Thực hiện truy vấn cơ sở dữ liệu để lấy các sản phẩm có productCategory tương tự
        List<Product> similarProducts = UserDB.getSimilarProducts(productCategory);
        
        // Chuyển danh sách sản phẩm sang dạng JSON
        String json = new Gson().toJson(similarProducts);
        
        // Gửi JSON về cho trình duyệt
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}