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

    public Employee getOnlyOneEmployee(Long id){
        if (getEmployee(id).isPresent()) {
            Employee dbObject = getEmployee(id).get();
            Employee employee = new Employee();
            employee.setEmpFirstName(dbObject.getEmpFirstName());
            employee.setEmpLastName(dbObject.getEmpLastName());
            employee.setMobile(dbObject.getMobile());
            employee.setGender(dbObject.getGender());
            employee.setEmail(dbObject.getEmail());
            employee.setDob(dbObject.getDob());
            employee.setAddress(dbObject.getAddress());
            employee.setSalary(dbObject.getSalary());
            employee.setHiringDate(dbObject.getHiringDate());
            employee.setDesignation(dbObject.getDesignation());
            employee.setDeptId(dbObject.getDeptId());
            employee.setId(dbObject.getId());
            return employee;
        }
        return null;
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

        Optional<Employee> optional = getEmployee(employee.getId());
        if (optional.isPresent()) {
            Employee oo = optional.get();//oo is original object from database
            oo.setEmpFirstName(employee.getEmpFirstName());
            oo.setEmpLastName(employee.getEmpLastName());
            oo.setMobile(employee.getMobile());
            oo.setGender(employee.getGender());
            oo.setEmail(employee.getEmail());
            oo.setDob(employee.getDob());
            oo.setAddress(employee.getAddress());
            oo.setSalary(employee.getSalary());
            oo.setHiringDate(employee.getHiringDate());
            oo.setDesignation(employee.getDesignation());
            oo.setDeptId(employee.getDeptId());
            return employeeRepository.save(oo);
        }
        return null;
    }
}
