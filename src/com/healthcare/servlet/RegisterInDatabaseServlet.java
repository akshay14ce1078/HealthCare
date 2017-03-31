package com.healthcare.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthcare.bean.HospitalDetails;
import com.healthcare.bean.UserDetails;
import com.healthcare.utility.HospitalLogic;
import com.healthcare.utility.LoginLogic;
import com.healthcare.utility.UserLogic;


@WebServlet("/user_registration")
public class RegisterInDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterInDatabaseServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String email = request.getParameter("Email");
		String pwd = request.getParameter("pwd");
		String contact1 = request.getParameter("Contact1");
		String contact2 = request.getParameter("Contact2");
		
		Connection conn = LoginLogic.getStoredConnection(request);
		try{
			//check if email-id already already exit
				UserLogic.addUser(conn, fname,lname,email,pwd,contact1,contact2);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlogin");
		        dispatcher.forward(request, response);
			
		    }
		catch (SQLException e){
			System.out.println("Error in registering user...");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
