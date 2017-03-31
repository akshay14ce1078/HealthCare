package com.healthcare.bean;

public class UserDetails {
int User_id,contact1,Contact2;
String Fname,Lname,Email,Pwd;
public int getUser_id() {
	return User_id;
}
public void setUser_id(int user_id) {
	User_id = user_id;
}
public int getContact1() {
	return contact1;
}
public void setContact1(int contact1) {
	this.contact1 = contact1;
}
public int getContact2() {
	return Contact2;
}
public void setContact2(int contact2) {
	Contact2 = contact2;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPwd() {
	return Pwd;
}
public void setPwd(String pwd) {
	Pwd = pwd;
}
}
