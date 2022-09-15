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

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatient(Long id){
        return patientRepository.findById(id);
    }


    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public String delete(Long id){
        Optional<Patient> optional = getPatient(id);
        if (optional.isPresent()){
            patientRepository.deleteById(id);
            return "Patient with id " + id + " is deleted!";
        } else
            return "Patient with id " + id + " not found";
        }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }
}
