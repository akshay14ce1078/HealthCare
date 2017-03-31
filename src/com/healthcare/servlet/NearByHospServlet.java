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
import com.healthcare.utility.HospitalLogic;
import com.healthcare.utility.LoginLogic;

@WebServlet(description = "getting nearby hospital", urlPatterns = { "/nearbyhosp" })
public class NearByHospServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public NearByHospServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn =LoginLogic.getStoredConnection(request);
		
		String latlong="19.000451,73.105013";
		
		try {
			HospitalDetails[] nearHosp=HospitalLogic.nearByHospital(conn, latlong);
			
			for(int i=0;i<nearHosp.length;i++){
				request.setAttribute("hosp_name"+i,nearHosp[i].getHosp_name());
				request.setAttribute("hosp_loc"+i,nearHosp[i].getHosp_location());
				request.setAttribute("hosp_contact"+i,nearHosp[i].getHosp_contact());
				request.setAttribute("hosp_lat"+i,nearHosp[i].getLatitude());
				request.setAttribute("hosp_long"+i,nearHosp[i].getLongitude());
			}
			request.setAttribute("length", nearHosp.length);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/UserInterface/nearbyhosp_page.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
