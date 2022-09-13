package com.company.clinapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.clinapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
