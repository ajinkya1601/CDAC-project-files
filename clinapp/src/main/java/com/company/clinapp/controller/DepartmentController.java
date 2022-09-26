package com.company.clinapp.controller;

import com.company.clinapp.entity.Department;
import com.company.clinapp.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/depts")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{deptId}")
    public Department getDepartment(@PathVariable Long deptId) {
        Optional<Department> optional = departmentService.getDepartment(deptId);
        if (optional.isPresent())
            return optional.get();
        else return null;
    }

    @PostMapping
    public Department save(@RequestBody Department department){
        return departmentService.save(department);
    }

    @DeleteMapping("/{deptId}")
    public String delete(@PathVariable Long deptId){
        return departmentService.delete(deptId);
    }


    @PutMapping
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @GetMapping("/onlyOneDept/{deptId}")
    public Department onlyOneDept(@PathVariable Long deptId){
        return departmentService.onlyOneDept(deptId);
    }

}
