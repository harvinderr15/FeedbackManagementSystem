package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entites.Course;
import com.cg.fms.entites.Employee;
import com.cg.fms.entites.Enrolment;
import com.cg.fms.repository.IParticipantRepository;

@Service
public class IParticipantService {

	@Autowired
	IParticipantRepository repo;

	public Enrolment enrollParticipant(Enrolment enrol) {
		return repo.save(enrol);

	}

	public List<Employee> viewParticipantList(Course course) {

		return repo.viewParticipantList(course);
	}
}
