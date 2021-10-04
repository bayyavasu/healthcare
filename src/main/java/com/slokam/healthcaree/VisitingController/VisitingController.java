package com.slokam.healthcaree.VisitingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slokam.healthcaree.Visitingservice.IVisitingService;

@Controller
@RequestMapping("visitings")
public class VisitingController{
@Autowired

	private IVisitingService vistitingservice;
@GetMapping("/ById/{id}")
	public ResponseEntity<List<Object[]>> getVisitingsByPatientId(@PathVariable Integer id)
	{
		return  ResponseEntity.ok(vistitingservice.getVisitingsByPatientId(id));
	}
}
