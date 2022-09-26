package com.company.clinapp.controller;

import com.company.clinapp.entity.Prescription;
import com.company.clinapp.service.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{prescriptionId}")
    public Prescription getPrescription(@PathVariable Long prescriptionId){
        Optional<Prescription> optional = prescriptionService.getPrescription(prescriptionId);
        if (optional.isPresent())
            return optional.get();
        else return null;
    }

    @PostMapping
    public Prescription save(@RequestBody Prescription prescription){
        return prescriptionService.save(prescription);
    }

    @DeleteMapping("/{prescriptionId}")
    public String delete(@PathVariable Long prescriptionId){
        return prescriptionService.delete(prescriptionId);
    }

    @PutMapping
    public Prescription update(@RequestBody Prescription prescription){
        return prescriptionService.update(prescription);
    }

    @GetMapping("/onlyOnePrescription/{prescriptionId}")
    public Prescription getOnlyOnePrescription(@PathVariable Long prescriptionId){
        return prescriptionService.getOnlyOnePrescription(prescriptionId);
    }

}
