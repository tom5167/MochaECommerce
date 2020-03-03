<%@page import="com.mocha.dto.Csr"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--
 * --------------------------------------------- 
 * @author KOZHI
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Mar 1, 2020 
 * modified Date : Nov 26, 2018
 * --------------------------------------------- 
 *
 * Page Task :   Welcome Page after login for CSR  
 * 
 *
 --%>
<!DOCTYPE html>
<html>
<head>
  <title> Mocha </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body { padding-top: 70px; }
</style>    
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 <div class="jumbotron">
 
	 <%
 	 	//Session  
 	 	 HttpSession sessionCsr = request.getSession();
 	 	 
 	 	 
 	 	 
 	 	 try{
 	 		 
 	 	 	Csr csr = (Csr) sessionCsr.getAttribute("csr");
 	 %>
	   	
	  		 
    		<h2>Welcome,  <%=csr.getFirstName()%>!</h2>
    		 
			<br>
			This page is for Customer Service Representatives to manage product, customer, and orders.

	 <%
	 	
	 
	 }
	 catch(Exception e)
	 {
	%>
		
		The username or password you entered is incorrect.
		
	<%	 
	 }
	 %>
 

   </div> 
 </div>
 
</div> 
</body>
</html>

