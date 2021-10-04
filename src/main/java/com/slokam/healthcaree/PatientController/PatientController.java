package com.slokam.healthcaree.PatientController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.healthcaree.Service.IPatientService;
import com.slokam.healthcaree.entity.Patient;
import com.slokam.healthcaree.entity.PatientSearchPojo;
import com.slokam.healthcaree.exception.HealthCareException;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Value("${app.file.upload.location}")
	private String uploadLocation;
	//private static Logger LOGGER=LoggerFactory.logger(PatientController.class);
	@Autowired
	private IPatientService patientservice;
	@PostMapping("/register")
		public ResponseEntity<Patient>  registerPatient(@RequestBody Patient patient)
		{
		patientservice.registerPatient(patient);
		return new ResponseEntity<Patient>(HttpStatus.CREATED);
	}
	@PostMapping("/saveImage")
	public ResponseEntity<String> uploadFile(MultipartFile patientImage) throws HealthCareException
	{
		String name=System.currentTimeMillis()+"-"+patientImage.getOriginalFilename();
		try {
			patientImage.transferTo(new File(uploadLocation+name));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			//e.printStackTrace();
			throw new HealthCareException("Specified file upload loaction is not available", e, 8000);

		}
	
		return new ResponseEntity<String>(name,HttpStatus.OK);
	}//spring.servlet.multipart.max-file-size=1000kb
	//spring.servlet.multipart.max-request-size=1000kb
	//spring.servlet.multipart.max-file-size=-1
			//spring.servlet.multipart.max-request-size=1
	@PostMapping("/search")
	public ResponseEntity<List<Patient>> searchPatient(@RequestBody PatientSearchPojo patient)
	{
		List<Patient> list=patientservice.searchPatient(patient);
	return  ResponseEntity.ok(list);	
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Patient>> getAll()
	{
		List<Patient> list=patientservice.getAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/getByID/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer id)
	{
		Patient p=patientservice.getPatientById(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/getAllevenPatients")
	public ResponseEntity<List<Patient>> getAllevenPatients()
	{
		List<Patient> list=patientservice.getAllevenPatients();
		List<Patient> list2=list.stream().filter(patient-> nullCheck(patient)&& patient.getId()%2==0).collect(Collectors.toList());
		
		return ResponseEntity.ok(list2);
	}
	
	@DeleteMapping("deletePatient/{id}")
	public void deletePatientById(@PathVariable Integer id){
		patientservice.deletePatientById(id);
	}
	public boolean nullCheck(Patient patient)
	{
		boolean flag=false;
		if(Objects.nonNull(patient))
		{
			if(patient.getId()!=null)
			{
				flag=true;
			}
		}
		
		return flag;
	}
	
	
	
	
	
	
}
