package com.healthcare.utility;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthcare.bean.UserDetails;
import com.healthcare.bean.HospitalDetails;

public class LoginLogic {
	  public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	  
	   private static final String ATT_NAME_user_NAME = "ATTRIBUTE_FOR_STORE_user_NAME_IN_COOKIE";
	   private static final String ATT_NAME_hospital_NAME = "ATTRIBUTE_FOR_STORE_hospital_NAME_IN_COOKIE";
	 
	    
	   // Store ONLY Connection in request attribute.
	   // (Information stored only exist during requests)
	   //As we do checking during request made and then redirect it appropriately
	   
	   //******Session is a part of request only as we write 'request.getSession();'******
	   
	   public static void storeConnection(ServletRequest request, Connection conn) {
	       request.setAttribute(ATT_NAME_CONNECTION, conn);
	   }
	 
	   // Get the Connection object has been stored in one attribute of the request.
	   public static Connection getStoredConnection(ServletRequest request) {
	       Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
	       return conn;
	   }
	 
	   // Store user info in Session.
	   public static void storeLoginedUserDetails(HttpSession session, UserDetails logineduser) {
	 
	       // On the JSP can access ${logineduser}
	       session.setAttribute("logineduser", logineduser);
	   }
	 
	 
	   // Get the user information stored in the session.
	   public static UserDetails getLoginedUserDetails(HttpSession session) {
	       UserDetails logineduser = (UserDetails) session.getAttribute("logineduser");
	       return logineduser;
	   }
	 
	 
	   // Store info in Cookie
	   public static void storeUserDetailsCookie(HttpServletResponse response, UserDetails user) {
	       System.out.println("Store user cookie");
	       Cookie cookieuserName = new Cookie(ATT_NAME_user_NAME, user.getFname());
	 
	       // 1 day (Convert to seconds)
	       cookieuserName.setMaxAge(24 * 60 * 60);
	       response.addCookie(cookieuserName);
	   }
	 
	   public static String getUserDetailsNameInCookie(HttpServletRequest request) {
	       Cookie[] cookies = request.getCookies();
	       if (cookies != null) {
	           for (Cookie cookie : cookies) {
	               if (ATT_NAME_user_NAME.equals(cookie.getName())) {
	                   return cookie.getValue();
	               }
	           }
	       }
	       return null;
	   }
	 
	 
	   // Delete cookie.
	   public static void deleteUserDetailsCookie(HttpServletResponse response) {
	       Cookie cookieuserName = new Cookie(ATT_NAME_user_NAME, null);
	 
	       // 0 seconds (Expires immediately)
	       cookieuserName.setMaxAge(0);
	       response.addCookie(cookieuserName);
	   }

	public static void storeLoginedHospitalDetails(HttpSession session, HospitalDetails loginedhospital) {
		  // On the JSP can access ${loginedhospital}
	       session.setAttribute("loginedhospital", loginedhospital);
		
	}

	  // Get the hospital information stored in the session.
	   public static HospitalDetails getLoginedHospitalDetails(HttpSession session) {
	       HospitalDetails loginedhospital = (HospitalDetails) session.getAttribute("loginedhospital");
	       return loginedhospital;
	   }
	
	public static void storeHospitalDetailsCookie(HttpServletResponse response, HospitalDetails hospital) {
		System.out.println("Store hospital cookie");
	       Cookie cookiehospitalName = new Cookie(ATT_NAME_hospital_NAME, hospital.getHosp_name());
	 
	       // 1 day (Convert to seconds)
	       cookiehospitalName.setMaxAge(24 * 60 * 60);
	       response.addCookie(cookiehospitalName);
		
	}

	public static String getHospitalDetailsNameInCookie(HttpServletRequest request) {
	       Cookie[] cookies = request.getCookies();
	       if (cookies != null) {
	           for (Cookie cookie : cookies) {
	               if (ATT_NAME_hospital_NAME.equals(cookie.getName())) {
	                   return cookie.getValue();
	               }
	           }
	       }
	       return null;
	   }
	
	public static void deleteHospitalDetailsCookie(HttpServletResponse response) {
		  Cookie cookiehospitalName = new Cookie(ATT_NAME_hospital_NAME, null);
			 
	       // 0 seconds (Expires immediately)
	       cookiehospitalName.setMaxAge(0);
	       response.addCookie(cookiehospitalName);
		
	}
}

