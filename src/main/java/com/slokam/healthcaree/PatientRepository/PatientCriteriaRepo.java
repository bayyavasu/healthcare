package com.slokam.healthcaree.PatientRepository;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcaree.entity.Patient;
import com.slokam.healthcaree.entity.PatientSearchPojo;
import com.slokam.healthcaree.utils.StringUtil;

@Repository
public class PatientCriteriaRepo {

	@Autowired
	private EntityManager em;
	public List<Patient> PatientFullSearch(PatientSearchPojo  patient)
	{
      CriteriaBuilder cb=em.getCriteriaBuilder();
      CriteriaQuery<Patient> cq=cb.createQuery(Patient.class);
      Root<Patient> root=cq.from(Patient.class);
      List<Predicate>  predicatelist=new ArrayList<>();
      if(patient!=null)
      {
    	  if(StringUtil.blankCheck(patient.getName()))
    	  {
    		  predicatelist.add((Predicate) cb.like(root.get("name"), patient.getName()+"%"));
    	  }
    	  if(patient.getPhone()!=null)
    	  {
    		  predicatelist.add(cb.equal(root.get("phone"), patient.getPhone()));  
    	  }
    	  if(patient.getFromdate()!=null)
    	  {
    		  predicatelist.add((Predicate) cb.greaterThanOrEqualTo(root.get("regDate"), patient.getFromdate()));
    	  }
    	  
    	  if(patient.getTodate()!=null)
    	  {
    		  predicatelist.add((Predicate) cb.lessThanOrEqualTo(root.get("regDate"), patient.getTodate()));
    	  }
    	  
    	  if(patient.getStartingAge()!=null)
    	  {
    		  predicatelist.add((Predicate) cb.greaterThanOrEqualTo(root.get("age"), patient.getStartingAge()));
    	  }
    	  if(patient.getEndingAge()!=null)
    	  {
    		  predicatelist.add((Predicate) cb.lessThanOrEqualTo(root.get("age"), patient.getEndingAge()));
    	  }
      }
     cq.where(predicatelist.toArray(new Predicate[predicatelist.size()]));
      TypedQuery<Patient>  patientQuery=em.createQuery(cq);
      return patientQuery.getResultList(); 
      
	} 

}
