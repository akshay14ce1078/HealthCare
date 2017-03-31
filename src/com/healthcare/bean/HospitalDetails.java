package com.healthcare.bean;

public class HospitalDetails {
int Hosp_id,Hosp_contact,grade;
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getHosp_id() {
	return Hosp_id;
}
public void setHosp_id(int hosp_id) {
	Hosp_id = hosp_id;
}
public int getHosp_contact() {
	return Hosp_contact;
}
public void setHosp_contact(int hosp_contact) {
	Hosp_contact = hosp_contact;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public String getHosp_name() {
	return Hosp_name;
}
public void setHosp_name(String hosp_name) {
	Hosp_name = hosp_name;
}
public String getHosp_location() {
	return Hosp_location;
}
public void setHosp_location(String hosp_location) {
	Hosp_location = hosp_location;
}
public String getHosp_pwd() {
	return Hosp_pwd;
}
public void setHosp_pwd(String hosp_pwd) {
	Hosp_pwd = hosp_pwd;
}
double latitude,longitude;
String Hosp_name,Hosp_location,Hosp_pwd;
}
