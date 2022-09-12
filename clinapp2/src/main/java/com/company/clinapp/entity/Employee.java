package com.company.clinapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int empId;
	
	@Column
	private String empFirstName;
	
	@Column
	private String empLastName;
	
	@Column
	private String mobile;
	
	@Column
	private String email;
	
	@Column
	private Date dob;
	
	@Column
	private String address;
	
	@Column
	private int salary;
	
	@Column
	private Date hiringDate;
	
	@Column
	private String designation;

	public Employee() {
		super();
	}

	public Employee(String empFirstName, String empLastName, String mobile, String email, Date dob, String address,
			int salary, Date hiringDate, String designation) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
		this.hiringDate = hiringDate;
		this.designation = designation;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", mobile=" + mobile + ", email=" + email + ", dob=" + dob + ", address=" + address + ", salary="
				+ salary + ", hiringDate=" + hiringDate + ", designation=" + designation + "]";
	}
	
}
