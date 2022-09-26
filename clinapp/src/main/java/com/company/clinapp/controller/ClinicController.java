package com.company.clinapp.controller;

import com.company.clinapp.entity.Clinic;
import com.company.clinapp.service.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public List<Clinic> getAllClinics(){
        return clinicService.getAllClinics();
    }


    @GetMapping("/{clinicId}")
    public Clinic getClinic(@PathVariable Long clinicId){
        Optional<Clinic> optional =clinicService.getClinic(clinicId);
        if (optional.isPresent())
            return optional.get();
        return null;
    }


    @PostMapping
    public Clinic save(@RequestBody Clinic clinic){
        return clinicService.save(clinic);
    }

    @DeleteMapping("/{clinicId}")
    public String delete(@PathVariable Long clinicId){
        return clinicService.delete(clinicId);
    }

    @PutMapping
    public Clinic update(@RequestBody Clinic clinic){
        return clinicService.update(clinic);
    }

    @GetMapping("/onlyOneClinic/{clinicId}")
    public Clinic onlyOneClinic(@PathVariable Long clinicId){
        return clinicService.onlyOneClinic(clinicId);
    }

}
