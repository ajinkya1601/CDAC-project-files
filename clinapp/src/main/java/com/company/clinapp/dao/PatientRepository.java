package com.company.clinapp.dao;

import com.company.clinapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByMobile(String mobile);
}
