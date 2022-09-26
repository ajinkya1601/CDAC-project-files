package com.company.clinapp.controller;

import com.company.clinapp.entity.Patient;
import com.company.clinapp.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patientRecordByMobile/{mobileNo}")
    public Patient patientRecordByMobile(@PathVariable String mobileNo){
        return patientService.patientRecordByMobile(mobileNo);
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Long patientId){
        Optional<Patient> optional = patientService.getPatient(patientId);
        if (optional.isPresent())
            return optional.get();
        else return null;
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @DeleteMapping("/{patientId}")
    public String delete(@PathVariable Long patientId){
        return patientService.delete(patientId);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        return patientService.update(patient);
    }

    @GetMapping("/onlyOnePatient/{patientId}")
    public Patient getOnlyOnePatient(@PathVariable Long patientId){
        return patientService.getOnlyOnePatient(patientId);
    }


}
