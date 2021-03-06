package com.mocha.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocha.dao.ShoesDAO;
import com.mocha.dto.Shoes;


/**
 * Servlet implementation class ShoeListController
 */

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
 *
 * Page Task	: Show Shoes' list 
 *				  select data (call ShoesDAO obj)-> set attribute for shoes Arraylist -> forward to ShoeList.jsp
 *
 */ 
@WebServlet("/ShoeListController")
public class CustShoeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustShoeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// category for menu 
		String category = request.getParameter("category");
		 
		
		// Object for DB tasks
		ShoesDAO shoesDao = new ShoesDAO();
		
		// Arraylist for shoes' list
		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
		
		try {
			
			// call method for list
			shoesList = shoesDao.listShoes(category);
			
			// set attribute
			request.setAttribute("category", category);
	        request.setAttribute("shoesList", shoesList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/ShoeList.jsp").forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
