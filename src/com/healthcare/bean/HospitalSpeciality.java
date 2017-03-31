package com.healthcare.bean;

public class HospitalSpeciality {
int Hsid,Hosp_id,grade;
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getHsid() {
	return Hsid;
}
public void setHsid(int hsid) {
	Hsid = hsid;
}
public int getHosp_id() {
	return Hosp_id;
}
public void setHosp_id(int hosp_id) {
	Hosp_id = hosp_id;
}
public String getSpeciality() {
	return Speciality;
}
public void setSpeciality(String speciality) {
	Speciality = speciality;
}
public String getDoctor() {
	return Doctor;
}
public void setDoctor(String doctor) {
	Doctor = doctor;
}

String Speciality,Doctor;
}
