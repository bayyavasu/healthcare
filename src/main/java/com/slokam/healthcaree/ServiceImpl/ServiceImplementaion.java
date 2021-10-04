package com.slokam.healthcaree.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcaree.PatientRepository.IPatientRepo;
import com.slokam.healthcaree.PatientRepository.PatientCriteriaRepo;
import com.slokam.healthcaree.Service.IPatientService;
import com.slokam.healthcaree.entity.Patient;
import com.slokam.healthcaree.entity.PatientSearchPojo;

@Service
public class ServiceImplementaion implements IPatientService {
	@Autowired
	IPatientRepo  patientrepo; 
	@Autowired
	PatientCriteriaRepo criteriarepo;
	@Override
	public void registerPatient(Patient patient)
	{
		patient.setRegDate(new Date());
		patientrepo.save(patient);
	}
	@Override
	public List<Patient> searchPatient(PatientSearchPojo patient) {
	return 	criteriarepo.PatientFullSearch(patient);
	
	}
	public List<Patient> getAll() {
	return 	patientrepo.findAll();

	
	}
	
	public Patient getPatientById(Integer id)
	{
		Optional<Patient> op=patientrepo.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		return null;
	}
	@Override
	public List<Patient> getAllevenPatients() {
		List<Patient> list=patientrepo.findAll();
		return list;
	}
	
	public void deletePatientById(Integer id){
		patientrepo.deleteById(id);
	}
	
	
}
