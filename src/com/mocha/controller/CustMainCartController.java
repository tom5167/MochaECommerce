package com.mocha.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mocha.dao.CartDAO;
import com.mocha.dto.Cart;
import com.mocha.dto.Customer;

/**
 * Servlet implementation class MyCartController
 */
/**
 * --------------------------------------------- 
 * @author KOZHI
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 27, 2018 
 * modified Date : Nov 27, 2018
 * --------------------------------------------- 
 *
 * Page Task	: Show cart list to place order
 *				  select data from cart 
 *				-> set attribute for cart Arraylist 
 *				-> forward to MyCart.jsp
 *   
 *
 */ 

@WebServlet("/MyCartController")
public class CustMainCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustMainCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sessionCustomer = request.getSession();
		Customer customer = (Customer)sessionCustomer.getAttribute("customer"); 
		
		if(customer==null ){
			// Dispatcher - forward to result page
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
 
		// objcustomerId
		CartDAO cartDao = new CartDAO();
		
		// result
		ArrayList<Cart> cartList = new ArrayList<Cart>();
	
		// search Cart
		try {
			cartList = cartDao.listCart(customer.getCustomerId());
		
	        request.setAttribute("cartList", cartList);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/CustCart.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
