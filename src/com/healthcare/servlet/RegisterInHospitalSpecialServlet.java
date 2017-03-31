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
import javax.servlet.http.HttpSession;

import com.healthcare.bean.HospitalDetails;
import com.healthcare.utility.HospitalLogic;
import com.healthcare.utility.LoginLogic;
//import com.healthcare.utility.UserLogic;




@WebServlet("/hospitalspecial")
public class RegisterInHospitalSpecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterInHospitalSpecialServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		HttpSession session =request.getSession();
		HospitalDetails loginedhospital = LoginLogic.getLoginedHospitalDetails(session);
		int id=loginedhospital.getHosp_id();
		int grade=loginedhospital.getGrade();
		
		String[] emergency=request.getParameterValues("emergency");
		
		String d1 = request.getParameter("d1");
		//System.out.println(e1+" "+d1);
		
		String d2 = request.getParameter("d2");
		//System.out.println(e2+" "+d2);
		
		String d3 = request.getParameter("d3");
		//System.out.println(e3+" "+d3);
		
		String d4 = request.getParameter("d4");
		//System.out.println(e4+" "+d4);
		
		String d5 = request.getParameter("d5");
		//System.out.println(e5+" "+d5);
		
		String d6 = request.getParameter("d6");
		//System.out.println(e6+" "+d6);
		
		String d7 = request.getParameter("d7");
		//System.out.println(e7+" "+d7);
		
		String d8 = request.getParameter("d8");
		//System.out.println(e8+" "+d8);

		Connection conn = LoginLogic.getStoredConnection(request);
		try{
			//check if email-id already already exit
				HospitalLogic.addHosp(conn,id,emergency,d1,d2,d3,d4,d5,d6,d7,d8,grade);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/hospitalhome");
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
