package com.company.clinapp.service;

import com.company.clinapp.dao.DepartmentRepository;
import com.company.clinapp.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public String delete(Long id) {

        if (getDepartment(id).isPresent()) {
            departmentRepository.deleteById(id);
            return "Department with id " + id + " is deleted!";
        } else
            return "Department with id " + id + " not found";
    }

    public Department update(Department clinic) {
        return departmentRepository.save(clinic);
    }

}
