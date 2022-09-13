package com.company.clinapp.controller;

import com.company.clinapp.entity.Employee;
import com.company.clinapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        Optional<Employee> optional = employeeService.getEmployee(employeeId);
        if (optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String delete(@PathVariable Long employeeId) {
        return employeeService.delete(employeeId);
    }
}
