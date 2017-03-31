package com.healthcare.utility;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.healthcare.bean.HospitalDetails;
import com.healthcare.bean.HospitalSpeciality;
import com.healthcare.bean.UserDetails;




public class UserLogic {
	public static UserDetails findUser(Connection conn,String User_id,String password)throws SQLException{
		
		
		String sql = "Select * from user_details " + " where Email = ? and Pwd= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, User_id);
	      pstm.setString(2, password);
	      ResultSet rs = pstm.executeQuery();
	 
	      if (rs.next()) {
	          UserDetails user=new UserDetails();
	          
	          user.setEmail(rs.getString("Email"));
	          user.setFname(rs.getString("Fname"));
	          user.setLname(rs.getString("Lname"));
	          user.setPwd(rs.getString("Pwd"));
	          user.setUser_id(rs.getInt("User_id"));
	          user.setContact1(rs.getInt("Contact1"));
	          user.setContact2(rs.getInt("Contact2"));
	          
	          return user;
	      }
	      return null;
	}
	
	
	public static void addUser(Connection conn, String fname,String lname, String email,
			String pwd, String contact1, String contact2) throws SQLException {
		
		String sql = "insert into user_details (Fname,Lname,Email,Pwd,Contact1,Contact2) values (?,?,?,?,?,?)";
	
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1,fname);
		pstm.setString(2,lname);
		pstm.setString(3,email);
		pstm.setString(4,pwd);
		pstm.setString(5,contact1);
		pstm.setString(6,contact2);

		pstm.execute();
		
	}
	
	
	//main algo for  suggesting hospital
	
	public static HospitalDetails suggestedHospitalAlgo(Connection conn,String suffering ,int emergency,int grade,String latlong)throws SQLException{
		
		latlong="19.000451,73.105013";
		HospitalDetails suggestedHosp=new HospitalDetails();
		
		String[] lg=latlong.split(",");
		
		double u_lat=Float.parseFloat(lg[0]);
		double u_long=Float.parseFloat(lg[1]);
		double latmax,latmin,longmax,longmin;
		
		latmax=u_lat+0.0211;
		latmin=u_lat-0.0211;
		longmax=u_long+0.0211;
		longmin=u_long-0.0211;
		System.out.println(latmax+" "+latmin+" "+longmax+" "+longmin);		
		String sql="select hosp_id,speciality,doctor,grade from hospital_speciality where hosp_id in(select hosp_id from hospital_details where (latitude between ? and ?) and (longitude between ? and ?))";
		
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
		HospitalSpeciality[] hospSpec=new HospitalSpeciality[i];
		
		
		ResultSet rs1=pstm.executeQuery();
		i=0;
		while(rs1.next()){ 		//filtre all hospital in 20km
			hospSpec[i]=new HospitalSpeciality();
			hospSpec[i].setHosp_id(rs1.getInt("hosp_id"));
			hospSpec[i].setSpeciality(rs1.getString("speciality"));
			hospSpec[i].setDoctor(rs1.getString("doctor"));
			hospSpec[i].setGrade(rs1.getInt("grade"));
			i++;
		}
		 
		if(emergency == 0){
			double min=1000,x,y,z,lati,longi;
				
			
			
			for(i=0;i<hospSpec.length;i++){
				PreparedStatement st=conn.prepareStatement("select * from hospital_details where Hosp_id=?"); 
				st.setInt(1,hospSpec[i].getHosp_id());
				ResultSet rs2=st.executeQuery();
				
				if (rs2.next()) {
					lati = rs2.getDouble("latitude");
					longi = rs2.getDouble("longitude");
					x = Math.abs(lati - u_lat);
					y = Math.abs(longi - u_long);
					z = Math.sqrt((x * x) + (y * y));
					if (min > z && hospSpec[i].getSpeciality().equals(suffering)) { //it should be nearest hosp and have treatment
						min = z;

						suggestedHosp.setHosp_id(rs2.getInt("Hosp_id"));
						suggestedHosp.setHosp_location(rs2.getString("Hosp_location"));
						suggestedHosp.setLatitude(rs2.getFloat("latitude"));
						suggestedHosp.setLongitude(rs2.getFloat("longitude"));
						suggestedHosp.setHosp_name(rs2.getString("Hosp_name"));
						suggestedHosp.setHosp_contact(rs2.getInt("Hosp_contact"));
					} 
				}
				
				rs2.close();
				st.close();
			}
			
			return suggestedHosp;
		}
		else if(emergency == 1){
		
			for(i=0;i<hospSpec.length;i++){ // to get all hospitals id having that particular treatment
				
				PreparedStatement st=conn.prepareStatement("select * from hospital_details where Hosp_id=?"); 
				st.setInt(1,hospSpec[i].getHosp_id());
				ResultSet rs3=st.executeQuery();
				
				
				if (rs3.next()) {
					if (hospSpec[i].getGrade() == grade && hospSpec[i].getSpeciality().equals(suffering)) {//match grade and treatment should available

						
						suggestedHosp.setHosp_id(rs3.getInt("Hosp_id"));
						suggestedHosp.setHosp_location(rs3.getString("Hosp_location"));
						suggestedHosp.setLatitude(rs3.getDouble("latitude"));
						suggestedHosp.setLongitude(rs3.getDouble("longitude"));
						suggestedHosp.setHosp_name(rs3.getString("Hosp_name"));
						suggestedHosp.setHosp_contact(rs3.getInt("Hosp_contact"));
					}
				}
					rs3.close();
					st.close();
					System.out.println("i="+i);
			}
			
			return suggestedHosp;
		}
		else{
			return null;
		}
		
	}
	
	

}
