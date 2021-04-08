package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entites.Course;
import com.cg.fms.entites.Employee;
import com.cg.fms.entites.Enrolment;
import com.cg.fms.service.IParticipantService;

@RestController
@RequestMapping("/api/enrol")
public class IParticipantController {

	@Autowired
	IParticipantService serve;

	@PostMapping("/add")
	public Enrolment enrollParticipant(@RequestBody Enrolment enrol) {
		return serve.enrollParticipant(enrol);
	}

	@GetMapping("/list/{id}")
	public List<Employee> viewParticipantListByProgram(@PathVariable String id) {
		Course course = new Course();
		course.setCourseId(id);
		return serve.viewParticipantList(course);
	}
}