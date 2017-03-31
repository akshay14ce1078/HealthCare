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

import com.healthcare.utility.LoginLogic;
import com.healthcare.utility.UserLogic;
import com.healthcare.bean.HospitalDetails;

@WebServlet("/suggesthosp")
public class SuggestHospServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuggestHospServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalDetails suggestedHosp;
		String suffering=request.getParameter("suffering");
		int grade=Integer.parseInt(request.getParameter("grade"));
		int emer_type=Integer.parseInt(request.getParameter("emer_type"));
		String latlong=request.getParameter("latlong");
		System.out.println("latlong="+latlong);
		System.out.println("grade="+grade);
		System.out.println("emer_type="+emer_type);
		
		latlong="19.000451,73.105013";
		String[] lg=latlong.split(",");
		double u_lat=Float.parseFloat(lg[0]);
		double u_long=Float.parseFloat(lg[1]);
		
		Connection conn=LoginLogic.getStoredConnection(request);
		try{
			suggestedHosp=UserLogic.suggestedHospitalAlgo(conn,suffering, emer_type, grade, latlong);
			if(suggestedHosp != null){
				request.setAttribute("hosp_name",suggestedHosp.getHosp_name());
				request.setAttribute("hosp_loc",suggestedHosp.getHosp_location());
				request.setAttribute("hosp_contact",suggestedHosp.getHosp_contact());
				request.setAttribute("hosp_lat",suggestedHosp.getLatitude());
				request.setAttribute("hosp_long",suggestedHosp.getLongitude());
				request.setAttribute("u_lat", u_lat);
				request.setAttribute("u_long", u_long);
				request.setAttribute("length", 1);
				
			}
			else{
				request.setAttribute("length", 0);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		

        RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/UserInterface/suggestedhosp_page.jsp");
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
