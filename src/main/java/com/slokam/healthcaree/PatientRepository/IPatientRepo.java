package com.slokam.healthcaree.PatientRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.slokam.healthcaree.entity.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer>{

}
