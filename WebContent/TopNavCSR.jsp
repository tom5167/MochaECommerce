 <%--
 * --------------------------------------------- 
 * @author KOZHI
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Mar 1, 2020 
 * modified Date : Mar 1, 2018
 * --------------------------------------------- 
 *
 * Page Task :  Top navigation for CSR  
 *  
 * 
 --%>
  
	 <!--  TOP MENU : After CRS Login-->
	 <nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="index.jsp">Mocha</a>
	    </div>
 		<ul class="nav navbar-nav">
	       
	      <li><a href="CsrShoeForm.jsp">New Product</a></li>
	      <li><a href="CsrShoeListController?category=Women">Product List</a></li>
	      <li><a href="CsrOrderListController">Order List</a></li>
	      <li><a href="CsrCustListController">Customers</a></li>
	    </ul>
		<ul class="nav navbar-nav navbar-right"> 
	      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>