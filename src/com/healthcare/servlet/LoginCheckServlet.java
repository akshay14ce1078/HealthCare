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
import com.healthcare.bean.UserDetails;
import com.healthcare.utility.HospitalLogic;
import com.healthcare.utility.LoginLogic;
import com.healthcare.utility.UserLogic;

@WebServlet(description = "check login details", urlPatterns = { "/logincheck" })
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginCheckServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User_id = request.getParameter("id");
        String password = request.getParameter("pwd");
        
        String err="";
        HospitalDetails validHosp=null;
        UserDetails validUser=null;
        int checking_for=0;
        
        
        if(User_id == null || password == null){
        	err="validUser name or password cannot be null";
        }
        else{
        	Connection conn=LoginLogic.getStoredConnection(request);
        	if(User_id.contains("@")){//validUser is patient
        		checking_for=0;
        		try{
            		validUser = UserLogic.findUser(conn, User_id, password);
            	}
            	catch (SQLException e) {
                    e.printStackTrace();
                    validUser = null;
                    err = e.getMessage();
                    System.out.println(err);
                }
        	}
        	else{// validUser is hospital
        		checking_for=1;
        		try{
            		validHosp = HospitalLogic.findHosp(conn, User_id, password);
            	}
            	catch (SQLException e) {
                    e.printStackTrace();
                    validHosp = null;
                    err = e.getMessage();
                    System.out.println(err);
                }
        	}
        }
        
        
        if(validUser != null){//validUser valid redirect to validUser home servlet 
        	HttpSession newSession=request.getSession();
        	LoginLogic.storeLoginedUserDetails(newSession, validUser);
        	newSession.setAttribute("valid_User",true);
        	newSession.setAttribute("user", validUser);//store p_id in session
        	
        	//finally redirect to validUser homepage
        	response.sendRedirect(request.getContextPath()+"/userhome");
        	 
        }
        else if(validHosp != null){
        		HttpSession newSession=request.getSession();
        		LoginLogic.storeLoginedHospitalDetails(newSession, validHosp);
        		newSession.setAttribute("valid_Hosp",true);
        		newSession.setAttribute("hosp", validHosp);//store doc_id in session
        		
        		//finally redirect to validUser homepage
        		response.sendRedirect(request.getContextPath()+"/hospitalhome");
        	 
        	}
        else{	//  else redirect to login page only
        	
        		// Store information in request attribute, before forward.
        	request.setAttribute("errorString", err);
            
        	if(checking_for == 0){
        		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/UserInterface/userlogin_page.jsp");
            	dispatcher.forward(request, response);	
        	}
        	else{
        		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/UserInterface/hosplogin_page.jsp");
            	dispatcher.forward(request, response);	
        	}
        	
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
