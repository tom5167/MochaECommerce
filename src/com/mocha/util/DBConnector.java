package com.mocha.util;

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

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mocha.logger.MochaLogger;

/**
 * DBConnector Class used to create jdbc connection to database
 */

public class DBConnector {
	
	static Logger logger = MochaLogger.getLogger();
        
	public static Connection getConnection(){
		Connection conn = null;
        try{
        	Properties props = new Properties();
        	String path = DBConnector.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("classes")[0];
        	FileInputStream in = new FileInputStream(path+"\\resources\\database.properties");
			props.load(in);
			in.close();
			String driver = props.getProperty("jdbc.driver");
			String connUrl = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			logger.info("connectionUrl -> "+connUrl);
			logger.info("jdbcDriver -> "+driver);
        	Class.forName(driver);
        	if(username != null && !username.isEmpty() 
        			&& password != null && !password.isEmpty()) {
        		conn = DriverManager.getConnection(connUrl,username, password);
        	} else {
        		conn = DriverManager.getConnection(connUrl);
        	}
            return conn;
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }


	public static void closeConnection(Connection con) throws Exception {
		if (con != null)
			con.close();
	}

	public static void closeConnectionAll(Connection con, Statement st, ResultSet rs) throws Exception {
		if (con != null)
			con.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}