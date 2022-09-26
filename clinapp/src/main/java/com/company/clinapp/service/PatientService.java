package com.company.clinapp.service;

import com.company.clinapp.dao.PatientRepository;
import com.company.clinapp.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient patientRecordByMobile(String mobile){
       return patientRepository.findByMobile(mobile);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    public Patient getOnlyOnePatient(Long id){
        if (getPatient(id).isPresent()){
            Patient patient = getPatient(id).get();
            Patient op = new Patient();
            op.setAddress(patient.getAddress());
            op.setAge(patient.getAge());
            op.setEmail(patient.getEmail());
            op.setEmployeeId(patient.getEmployeeId());
            op.setFirstName(patient.getFirstName());
            op.setLastName(patient.getLastName());
            op.setId(patient.getId());
            op.setMobile(patient.getMobile());
            op.setDeptId(patient.getDeptId());
            return op;
        }
        return null;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public String delete(Long id) {
        Optional<Patient> optional = getPatient(id);
        if (optional.isPresent()) {
            patientRepository.deleteById(id);
            return "Patient with id " + id + " is deleted!";
        } else
            return "Patient with id " + id + " not found";
    }

    public Patient update(Patient patient) {
        Optional<Patient> optional = getPatient(patient.getId());
        if (optional.isPresent()){
            Patient op = optional.get();//oo is original object from database
            op.setAddress(patient.getAddress());
            op.setAge(patient.getAge());
            op.setEmail(patient.getEmail());
            op.setEmployeeId(patient.getEmployeeId());
            op.setFirstName(patient.getFirstName());
            op.setLastName(patient.getLastName());
            op.setId(patient.getId());
            op.setMobile(patient.getMobile());
            op.setDeptId(patient.getDeptId());
            return patientRepository.save(op);
        }
        return null;
    }
}
