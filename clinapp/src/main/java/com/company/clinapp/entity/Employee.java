package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empId;

	private String empFirstName;
	private String empLastName;
	private String mobile;
	private String email;
	private String dob;
	private String address;
	private int salary;
	private String hiringDate;
	private String designation;
	private String departmentName;
	private int clinicId;
}
