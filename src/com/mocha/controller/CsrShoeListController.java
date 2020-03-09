package com.mocha.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocha.dto.Shoes;
import com.mocha.util.DBConnector;

/**
 * Servlet implementation class LoginController
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
 * Page Task	: CSR page - Show Shoes' list 
 *				  select data -> set attribute for shoes Arraylist -> forward to CrsShoeList.jsp
 *
/**
 * Servlet implementation class CsrShoeListController
 */
@WebServlet("/CsrShoeListController")
public class CsrShoeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Connection con;
	PreparedStatement pst; 
	ResultSet rs;
	
	
    public CsrShoeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 String category = request.getParameter("category");
		 
		 // select shoe list	
		 try {
				
				// create sql  
				String sql = "select itemId, itemName, category, shoesize, quantity, price,content  from Shoes "
						+ " where category = '" + category + "' order by itemId desc ";
		     
		        // DB connection
				con = DBConnector.getConnection();

		        // resultSet
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery(); 
				
				// ArrayList for Shoes
				
        		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
        		
		         while(rs.next())
		  		 {
		        
		        		
		        	 	Shoes shoe = new Shoes();
			 	        
		        	 	// store information	
		        		shoe.setItemId(rs.getInt(1));
		        		shoe.setItemName(rs.getString(2));
		        		shoe.setCategory(rs.getString(3));
		        		shoe.setShoesize(rs.getString(4));
		        		shoe.setQuantity(rs.getInt(5));
		        		shoe.setPrice(rs.getDouble(6));
		        		shoe.setContent(rs.getString(7));
		        		 
		        		
		        		shoesList.add(shoe); 
		 	   		 
		  		 }
		  		 
		         // set attribute
		         request.setAttribute("category", category);
		         request.setAttribute("shoesList", shoesList);
		         
				
			}catch(SQLException e)
		    {
			   e.printStackTrace(); 
		    }
		    catch(Exception e)
		    {
			   e.printStackTrace(); 
		    }
			finally{
				 if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		         if(pst!=null)
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		         if(rs!=null)
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}    	
			}
			 
			// Dispatcher - forward to result page
			getServletContext().getRequestDispatcher("/CsrShoesList.jsp").forward(request, response);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
