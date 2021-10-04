package com.slokam.healthcaree.VisitingImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcaree.VisitingRepository.IVisitingRepo;
import com.slokam.healthcaree.Visitingservice.IVisitingService;

@Service
public class VisitingImpl  implements IVisitingService{
	@Autowired
	private IVisitingRepo visitingRepo;
	@Override
	public List<Object[]> getVisitingsByPatientId(Integer id) {
		return visitingRepo.getVisitingsByPatientId1(id);	
	}
}
