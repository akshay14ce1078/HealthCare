package com.healthcare.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthcare.bean.HospitalDetails;


public class HospitalLogic {
public static HospitalDetails findHosp(Connection conn,String User_id,String password)throws SQLException{
		
		
		String sql = "Select * from hospital_details " + " where Hosp_id = ? and Hosp_pwd= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, User_id);
	      pstm.setString(2, password);
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          HospitalDetails hosp=new HospitalDetails();
	          hosp.setHosp_id(rs.getInt("hosp_id"));
	          hosp.setHosp_location(rs.getString("hosp_location"));
	          hosp.setLatitude(rs.getFloat("latitude"));
	          hosp.setLongitude(rs.getFloat("longitude"));
	          hosp.setHosp_pwd(rs.getString("hosp_pwd"));
	          hosp.setHosp_name(rs.getString("hosp_name"));
	          hosp.setHosp_contact(rs.getInt("hosp_contact"));
	          hosp.setGrade(rs.getInt("grade"));
	          
	          return hosp;
	      }
	      return null;
	}

public static void addHosp(Connection conn,int id,String[] emergency,String d1,String d2,
	    String d3,String d4,String d5,String d6,
		String d7,String d8,int grade) throws SQLException {
	
	
	for(String e:emergency)
	{
		if(e.equals("Chest Pain"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d1);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Abdominal Pain"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d2);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Back Pain"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d3);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Strain/Sprain Injury"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d4);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Accidental Injury"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d5);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("EyeSight Problem"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d6);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Brain Hamorrhage"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d7);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
		if(e.equals("Feeds Attack"))
		{
			String sql = "insert into hospital_speciality (Hosp_id,Speciality,Doctor,Grade) values (?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			pstm.setString(2,e);
			pstm.setString(3,d8);
			pstm.setInt(4,grade);
			pstm.execute();
			pstm.close();
			continue;
		}
	}  //for ends
	
	}

public static HospitalDetails[] nearByHospital(Connection conn,String latlong)throws SQLException{
		

		
		latlong="19.000451,73.105013";
		
		
		String[] lg=latlong.split(",");
		
		double u_lat=Float.parseFloat(lg[0]);
		double u_long=Float.parseFloat(lg[1]);
		double latmax,latmin,longmax,longmin;
		
		
		latmax=u_lat+0.0211;
		latmin=u_lat-0.0211;
		longmax=u_long+0.0211;
		longmin=u_long-0.0211;
		System.out.println(latmax+" "+latmin+" "+longmax+" "+longmin);		
		String sql="select * from hospital_details where (latitude between ? and ?) and (longitude between ? and ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDouble(1,latmin );
		pstm.setDouble(2,latmax );
		pstm.setDouble(3,longmin );
		pstm.setDouble(4,longmax);
		ResultSet rs=pstm.executeQuery();
	
		
		
		int i=0;
		while(rs.next()){
			i++;
		}
		System.out.println("count="+i);
		
		HospitalDetails[] nearHosp=new HospitalDetails[i];
		ResultSet rs2=pstm.executeQuery();
		
		for(i=0;i<nearHosp.length;i++){
			
			
			
			if (rs2.next()) {
				nearHosp[i]=new HospitalDetails();
				nearHosp[i].setHosp_id(rs2.getInt("Hosp_id"));
				nearHosp[i].setHosp_location(rs2.getString("Hosp_location"));
				nearHosp[i].setLatitude(rs2.getFloat("latitude"));
				nearHosp[i].setLongitude(rs2.getFloat("longitude"));
				nearHosp[i].setHosp_name(rs2.getString("Hosp_name"));
				nearHosp[i].setHosp_contact(rs2.getInt("Hosp_contact"));
				nearHosp[i].setHosp_contact(rs2.getInt("Hosp_contact"));
			}
			
		}
		rs2.close();
		pstm.close();
		
		return nearHosp;
	}
	



}
