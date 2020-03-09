package com.mocha.controller;

/*
 * Copyright (C) 2020 - Mocha - An online shoe shopping e-commerce website
 *
 * Licensed under Mocha CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate PatientCare's confidential information. 
 * User shall take all reasonable precautions necessary to safeguard the confidentiality of all confidential information.  
 * 
 * User shall not:
 * (a) allow the removal or defacement of any confidentiality or proprietary notice placed on any confidential information
 * (a) permit any other person or third party to use or access the class; 
 * (b) sublicense, redistribute, sell, lease, or otherwise make the class available to any other person or third party;
 * (c) redistribute through personal email accounts, USB drives, internal or third party FTP sites, or internal share drives;  
 * (c) reproduce, copy, translate, modify, adapt, decompile, disassemble or reverse engineer any portion of the class or 
 *     otherwise attempt to secure the source code of all or any part of the Software; 
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mocha.dto.Customer;
import com.mocha.logger.MochaLogger;
import com.mocha.util.DBConnector;

/**
 * 
 * LoginCustController Class - This class is for customer login
 * 
 * @version 1.0
 * @author KOZHI
 * @since Apr 1,2020
 * 
 */

@WebServlet("/LoginController")
public class LoginCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger logger = MochaLogger.getLogger();

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * LoginCustController.LoginCustController()
	 * 
	 * @return void
	 */
	public LoginCustController() {
		super();
	}

	/**
	 * LoginCustController.doGet()
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return void
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("LoginCustController.doGet() starts");

		// forward page
		String nextPage = "";

		// variables
		response.setContentType("text/html");

		// get params
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String userType = request.getParameter("userType");

		try {

			// create sql according to login type ( customer or CRS )
			String sql = "";

			if (userType.equals("user")) {
				sql = "select * from Customers where customerId=? and userpwd=? ";

			} else if (userType.equals("csr")) {
				sql = "select * from CSR where employeeId=? and userpwd=? ";
			}

			con = DBConnector.getConnection();

			// resultSet
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, pwd);
			rs = pst.executeQuery();

			// move to last row to count rows
			rs.last();

			if (rs.getRow() == 0) {

				// fail to login
				request.setAttribute("loginMsg", "fail");
				nextPage = "/Login.jsp";

			} else {

				// move to first row
				rs.beforeFirst();

				// get result
				while (rs.next()) {
					// customer
					Customer customer = new Customer();

					// get information
					customer.setCustomerId(rs.getString("customerId"));
					customer.setUserName(rs.getString("userName"));
					customer.setFirstName(rs.getString("firstName"));
					customer.setLastName(rs.getString("lastName"));
					customer.setAddress(rs.getString("address"));
					customer.setCity(rs.getString("city"));
					customer.setPostalCode(rs.getString("postalCode"));

					// set session
					HttpSession session = request.getSession();
					session.setAttribute("userType", "customer");
					session.setAttribute("customer", customer);
					session.setMaxInactiveInterval(120 * 60); // for customer give 120 minutes

					nextPage = "/LoginRst.jsp";

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		// forward to result page
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request, response);
		logger.info("LoginCustController.doGet() ends");
	}

	/**
	 * LoginCustController.doPost()
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return void
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("LoginCustController.doPost() starts");
		doGet(request, response);
		logger.info("LoginCustController.doPost() ends");
	}

}
