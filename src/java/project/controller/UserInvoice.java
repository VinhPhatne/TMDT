package project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import project.business.Account;
import project.business.Invoice;
import project.business.Payment;
import project.business.Product;
import project.data.UserDB;

public class UserInvoice extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "account"; 
        }
        if (action.equals("account")) {
            Account account = (Account) session.getAttribute("acc");
            int a = account.getUserId();
            List<Invoice> invoices = UserDB.selectInvoiceByUserId(a);

            Invoice i = new Invoice();
            int id = i.getInvoiceID();
            String payId = Integer.toString(id);
            response.getWriter().write("Payment URL: " + payId);
            List<Payment> payments = UserDB.selectPaymentByInvoiceId(payId);
            request.setAttribute("payments", payments);
            request.setAttribute("invoices", invoices);
            //request.getRequestDispatcher("UserInvoice.jsp").forward(request, response);
            } 
        else if (action.equals("admin")) {
            List<Invoice> invoices = UserDB.getAllInvoices();
            Invoice i = new Invoice();
            int id = i.getInvoiceID();
            String payId = Integer.toString(id);
            int length = payId.length();

            // Nếu chuỗi có ít hơn 8 ký tự, thêm số 0 ở đầu cho đến khi có đúng 8 ký tự
            while (length < 8) {
                payId = "0" + payId;
                length++;
            }
            List<Payment> payments = UserDB.selectPaymentByInvoiceId(payId);
            request.setAttribute("payments", payments);
            request.setAttribute("invoices", invoices);
            //request.getRequestDispatcher("UserInvoice.jsp").forward(request, response);
        }
        }catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("home");
        }
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}