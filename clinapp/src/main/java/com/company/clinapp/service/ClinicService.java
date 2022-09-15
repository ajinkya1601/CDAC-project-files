package com.company.clinapp.service;

import com.company.clinapp.dao.ClinicRepository;
import com.company.clinapp.entity.Clinic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    private ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public List<Clinic> getAllClinics() {

        return clinicRepository.findAll();
    }

    public Optional<Clinic> getClinic(Long id) {
        return clinicRepository.findById(id);
    }


    public Clinic save(Clinic clinic) {
        return clinicRepository.save(clinic);
    }


    public String delete(Long id) {

        if (getClinic(id).isPresent()) {
            clinicRepository.deleteById(id);
            return "Clinic with id " + id + " is deleted!";
        } else
            return "Clinic with id " + id + " not found";
    }


    public Clinic update(Clinic clinic) {
        return clinicRepository.save(clinic);
    }
}
