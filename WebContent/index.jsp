<%@page import="com.mocha.dto.Customer"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%--
/**
 * --------------------------------------------- 
 * @author KOZHI
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Mar 1, 2020 
 * modified Date : Mar 1, 2018
 * --------------------------------------------- 
  
 * Task	: index page  - forward page
 *
 *
 */ 
 --%>

	 <%
	 //Session check
	 HttpSession session2 = request.getSession();
	  
	 synchronized(session2) {
   	  
         String userType = (String)session2.getAttribute("userType");
         
         
         if (session.getAttribute("customer") == null && session.getAttribute("csr") == null) {
        
     %>

     		<jsp:forward page="Login.jsp" />
     <%	
         } else {
        	 
        	 
        	 //System.out.print(userType);
        	 
        	 if(userType.equals("csr")){
        		  
        		 %>
        		 		 <jsp:forward page="LoginCSRRst.jsp" />
        		 <%		 
        	 }else if(userType.equals("customer")){
       		  
       		 %>
       		 		 	<jsp:forward page="LoginRst.jsp" />
       		 <%		 
       	 	} 	 
            
         } 
         
      }
	  
	 %>
 

 