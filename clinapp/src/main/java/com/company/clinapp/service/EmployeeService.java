package com.company.clinapp.service;

import com.company.clinapp.dao.EmployeeRepository;
import com.company.clinapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public String delete(Long id) {
        if (getEmployee(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee with id " + id + " is deleted!";
        } else
            return "Employee with id " + id + " not found";
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
