<%@page import="com.mocha.dto.Customer"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%--
   * 
   * @author KOZHI
   * LoginRst.jsp - Welcome Page after login for customer  
   *
   --%>
<!DOCTYPE html>
<html>
   <head>
      <title>Mocha</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <style>
         body {
         padding-top: 70px;
         }
      </style>
   </head>
   <body>
      <div class="container-fluid">
         <!--  INCLUDE : TOP MENU NAVIGATION  -->
         <jsp:include page="/TopNav.jsp" />
         <div class="container">
            <div class="jumbotron" style="background-color: #D5D5D5;">
               <%
                  //Session  
                  HttpSession sessionCustomer = request.getSession();
                  
                  try{
                   
                  	Customer customer = (Customer)sessionCustomer.getAttribute("customer"); 
                  %>
               <h2><%=customer.getFirstName() %>, <br>Welcome to BEST
                  SHOES !
               </h2>
               <br>
               <br>
               <h3>
                  Free shipping on orders over $100. <br> All <font color="red">Kids
                  boots</font> on SALE !! <br>
               </h3>
               <%
                  }
                  catch(Exception e)
                  {
                  %>
               <jsp:forward page="Login.jsp" />
               <%	 
                  }
                  %>
            </div>
         </div>
      </div>
      <script
         src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script
         src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </body>
</html>