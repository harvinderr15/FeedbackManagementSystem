package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entites.Course;
import com.cg.fms.entites.Employee;
import com.cg.fms.entites.Enrolment;


@Repository
public interface IParticipantRepository extends CrudRepository<Enrolment, Integer>

{
	
	@Query("Select e.employee from Enrolment e where e.program.course=?1")
	public List<Employee> viewParticipantList(Course course);

}
