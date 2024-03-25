///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package project.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import project.business.Payment;
//import project.business.Product;
//import project.data.UserDB;
//
///**
// *
// * @author nguye
// */
//public class PaymentInfoServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String url;
//        //try {
////                String amount =request.getParameter("vnp_Amount");
////                String bankcode = request.getParameter("vnp_BankCode");
////                String orderinfo = request.getParameter("vnp_OrderInfo");
////                String paydate = request.getParameter("vnp_PayDate");
////                String txnref = request.getParameter("vnp_TxnRef");
////                String transactionno = request.getParameter("vnp_TransactionNo");
////                String transactionstatus = request.getParameter("vnp_TransactionStatus");
//
//                
//                Payment payment = new Payment();
////                payment.setAmount(amount);
////                payment.setBankcode(bankcode);
////                payment.setOrderinfo(orderinfo);
////                payment.setPaydate(paydate);
////                payment.setTxnref(txnref);
////                payment.setTransactionno(transactionno);
////                payment.setTransactionstatus(transactionstatus);
//                response.getWriter().write("TC "+ payment.getAmount());
////                if (amount != null && bankcode != null) {
////                    //UserDB.insert(payment);
////                    response.getWriter().write("TC" + payment.getAmount());
////                    //url = "/thanks.jsp"; 
////                    
////                    //request.setAttribute("payment", payment);
////                } else {
////                    //url = "/errorrrr.jsp";
////                    request.setAttribute("errorMessage", "Validation error: All fields are required.");
////                }
////            } catch (NumberFormatException e) {
////                //url = "/error.jsp";
////                request.setAttribute("errorMessage", "Validation error: Invalid payment price.");
//            }
//        //getServletContext().getRequestDispatcher(url).forward(request, response);
//    
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
