package com.company.clinapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.clinapp.entity.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long>{

}
