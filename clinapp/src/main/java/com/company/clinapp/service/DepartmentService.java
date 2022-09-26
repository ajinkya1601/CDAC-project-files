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

    public Department onlyOneDept(Long id){
        if (getDepartment(id).isPresent()){
            Department dbObject = getDepartment(id).get();
            Department department = new Department();
            department.setId(dbObject.getId());
            department.setDeptName(dbObject.getDeptName());
            department.setClinicId(dbObject.getClinicId());
            return department;
        }
        return null;
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

    public Department update(Department department) {
        Optional<Department> optional = getDepartment(department.getId());
        if (optional.isPresent()) {
            Department oo = optional.get();//oo is original object from database
            oo.setId(department.getId());
            oo.setDeptName(department.getDeptName());
            oo.setClinicId(department.getClinicId());
            return departmentRepository.save(oo);
        }
        return null;
    }

}
