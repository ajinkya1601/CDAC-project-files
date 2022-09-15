package com.company.clinapp.service;

import com.company.clinapp.dao.PrescriptionRepository;
import com.company.clinapp.entity.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    private PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> getPrescription(Long id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public String delete(Long id) {
        if (getPrescription(id).isPresent()) {
            prescriptionRepository.deleteById(id);
            return "Prescription with id " + id + " is deleted!";
        } else
            return "Prescription with id " + id + " not found";
    }

    public Prescription update(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }
}
