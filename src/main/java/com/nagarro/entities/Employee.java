package com.nagarro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Employee entity class with basic data of an employee - employeeCode,
 * employeeName, location, email, dateOfBirth
 * 
 * @author palakkharbanda
 *
 */
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeCode;
	private String employeeName;
	private String location;
	private String email;
	private String dob;

	public Employee(Long employeeCode, String employeeName, String location, String email, String dob) {
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.location = location;
		this.email = email;
		this.dob = dob;
	}

	public Employee() {
	}

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
