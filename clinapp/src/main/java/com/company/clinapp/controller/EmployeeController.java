package com.company.clinapp.controller;

import com.company.clinapp.entity.Employee;
import com.company.clinapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Slf4j
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


    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/onlyOneEmplyoee/{employeeId}")
    public Employee getOnlyOneEmployee(@PathVariable Long employeeId){
        return employeeService.getOnlyOneEmployee(employeeId);
    }

}
