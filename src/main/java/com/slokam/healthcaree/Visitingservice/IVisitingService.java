package com.slokam.healthcaree.Visitingservice;

import java.util.List;

public interface IVisitingService {
	abstract public List<Object[]> getVisitingsByPatientId(Integer id);
}
