<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="project.config.Config"%>
<%@page import="project.business.Payment"%>
<%@page import="project.data.UserDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>KẾT QUẢ THANH TOÁN</title>
        <!-- Bootstrap core CSS -->
        <link href="/ProjectFinal1/web/assets/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="/ProjectFinal1/web/assets/jumbotron-narrow.css" rel="stylesheet"> 
        <script src="/ProjectFinal1/web/assets/jquery-1.11.3.min.js"></script>
    </head>
    <body>
        <%
            // Xác thực và kiểm tra chữ ký ở đây...

            // Nếu giao dịch thành công, lưu thông tin vào CSDL
            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                // Tạo đối tượng Payment và set các giá trị từ request
                Payment payment = new Payment();
                payment.setAmount(request.getParameter("vnp_Amount"));
                payment.setBankcode(request.getParameter("vnp_BankCode"));
                payment.setOrderinfo(request.getParameter("vnp_OrderInfo"));
                payment.setPaydate(request.getParameter("vnp_PayDate"));
                payment.setTxnref(request.getParameter("vnp_TxnRef"));
                payment.setTransactionno(request.getParameter("vnp_TransactionNo"));
                payment.setTransactionstatus(request.getParameter("vnp_TransactionStatus"));

                // Lưu vào CSDL bằng cách gọi phương thức savePayment của PaymentDAO
                //UserDB paymentDAO = new UserDB();
                UserDB.insert(payment);
                System.out.println("Giao dịch đã được lưu thành công!");
            }
        %>
        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

        %>
        <!--Begin display -->
        <div class="container">
            <div class="header clearfix">
                <h3 class="text-muted">KẾT QUẢ THANH TOÁN</h3>
            </div>
            <div class="table-responsive">
                <div class="form-group">
                    <label >Mã giao dịch thanh toán:</label>
                    <label><%=request.getParameter("vnp_TxnRef")%></label>
                </div>    
                <div class="form-group">
                    <label >Số tiền:</label>
                    <label id="amount"><%=request.getParameter("vnp_Amount")%></label>
                </div>  
                <div class="form-group">
                    <label >Mô tả giao dịch:</label>
                    <label><%=request.getParameter("vnp_OrderInfo")%></label>
                </div> 
                <div class="form-group">
                    <label >Mã lỗi thanh toán:</label>
                    <label><%=request.getParameter("vnp_ResponseCode")%></label>
                </div> 
                <div class="form-group">
                    <label >Mã giao dịch tại CTT VNPAY-QR:</label>
                    <label><%=request.getParameter("vnp_TransactionNo")%></label>
                </div> 
                <div class="form-group">
                    <label >Mã ngân hàng thanh toán:</label>
                    <label><%=request.getParameter("vnp_BankCode")%></label>
                </div> 
                <div class="form-group">
                    <label >Thời gian thanh toán:</label>
                    <label><%=request.getParameter("vnp_PayDate")%></label>
                </div> 
                <div class="form-group">
                    <label >Tình trạng giao dịch:</label>
                    <label>
                        <%
                            if (signValue.equals(vnp_SecureHash)) {
                                if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                    out.print("Thành công");
                                } else {
                                    out.print("Không thành công");
                                }

                            } else {
                                out.print("invalid signature");
                            }
                        %></label>
                </div> 
                <div><form action="./thanks.jsp" method="post" class="button-cart">
                    <button class="primary-button">Back</button>
                </form></div>
            </div>
            <p>
                &nbsp;
            </p>
            <footer class="footer">
                <p>&copy; VNPAY 2020</p>
            </footer>
        </div>  
        <script>
            // Lấy giá trị từ label và gửi đến Servlet bằng AJAX
            var orderInfoValue = document.getElementById('amount').innerText;
        
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'payinfo?vnp_Amount=' + encodeURIComponent(orderInfoValue), true);
            xhr.send();
        </script>
    </body>
</html>
