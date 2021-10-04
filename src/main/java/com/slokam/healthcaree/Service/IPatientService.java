package com.slokam.healthcaree.Service;


import java.util.List;

import com.slokam.healthcaree.entity.Patient;
import com.slokam.healthcaree.entity.PatientSearchPojo;


public interface IPatientService {
public void registerPatient(Patient patient);
public List<Patient> searchPatient(PatientSearchPojo patient);
public List<Patient> getAll();
public Patient getPatientById(Integer id);
public List<Patient> getAllevenPatients();
public void deletePatientById(Integer id);
}
