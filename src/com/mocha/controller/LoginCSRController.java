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

import com.mocha.dto.Csr;
import com.mocha.logger.MochaLogger;
import com.mocha.util.DBConnector;

/**
 * 
 * LoginCSRController Class - class is for CSR login
 * 
 * @version 1.0
 * @author KOZHI
 * @since Apr 1,2020
 * 
 */
@WebServlet("/LoginCSRController")
public class LoginCSRController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger logger = MochaLogger.getLogger();

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * LoginCSRController.LoginCSRController()
	 * 
	 * @return void
	 */
	public LoginCSRController() {
		super();
	}

	/**
	 * LoginCSRController.doGet()
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return void
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("LoginCSRController - doGet() starts");

		// forward page
		String nextPage = "";

		// get params
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		try {

			// create sql according to login type ( customer or CRS )
			String sql = "select * from CSR where employeeId=? and userpwd=? ";

			// DB connection
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

					// CSR obj
					Csr csr = new Csr();

					// get information
					csr.setEmployeeId(rs.getString("employeeId"));
					csr.setFirstName(rs.getString("firstName"));
					csr.setLastName(rs.getString("lastName"));
					csr.setUserName(rs.getString("userName"));

					// set session
					HttpSession session = request.getSession();
					session.setAttribute("userType", "csr");
					session.setAttribute("csr", csr);
					session.setMaxInactiveInterval(600 * 60); // for customer give 600 minutes

					nextPage = "/LoginCSRRst.jsp";

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
		logger.info("LoginCSRController - doGet() ends");
	}

	/**
	 * LoginCSRController.doPost()
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return void
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("LoginCSRController - doPost() starts");
		doGet(request, response);
		logger.info("LoginCSRController - doPost() ends");
	}

}
