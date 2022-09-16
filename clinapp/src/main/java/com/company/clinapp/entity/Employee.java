package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String empFirstName;
	private String empLastName;
	private String mobile;
	private String gender;
	private String email;
	private String dob;
	private String address;
	private int salary;
	private String hiringDate;
	private String designation;
	private Long deptId;


	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="employeeId")
	private List<Patient> patients;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private List<DocQualification> docQualifications;
	//, insertable = false, updatable = false
}
