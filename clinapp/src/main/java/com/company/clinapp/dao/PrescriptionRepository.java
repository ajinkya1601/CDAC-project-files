package com.company.clinapp.dao;

import com.company.clinapp.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}
