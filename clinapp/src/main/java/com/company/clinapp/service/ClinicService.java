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

    public Clinic onlyOneClinic(Long id){
       if (getClinic(id).isPresent()){
           Clinic dbObject = getClinic(id).get();
           Clinic clinic = new Clinic();
           clinic.setId(dbObject.getId());
           clinic.setClinicName(dbObject.getClinicName());
           clinic.setClinicAddress(dbObject.getClinicAddress());
           clinic.setClinicPhone(dbObject.getClinicPhone());
           clinic.setMorningTime(dbObject.getMorningTime());
           clinic.setAfternoonTime(dbObject.getAfternoonTime());
           clinic.setEveningTime(dbObject.getEveningTime());
           clinic.setRegistrationDate(dbObject.getRegistrationDate());
           return clinic;
       }
       return null;
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
        Optional<Clinic> optional = getClinic(clinic.getId());
        if (optional.isPresent()) {
            Clinic oo = optional.get(); //oo is original object from database
            oo.setId(clinic.getId());
            oo.setClinicName(clinic.getClinicName());
            oo.setClinicAddress(clinic.getClinicAddress());
            oo.setClinicPhone(clinic.getClinicPhone());
            oo.setMorningTime(clinic.getMorningTime());
            oo.setAfternoonTime(clinic.getAfternoonTime());
            oo.setEveningTime(clinic.getEveningTime());
            oo.setRegistrationDate(clinic.getRegistrationDate());
            return clinicRepository.save(oo);
        }
        return null;
    }
}
