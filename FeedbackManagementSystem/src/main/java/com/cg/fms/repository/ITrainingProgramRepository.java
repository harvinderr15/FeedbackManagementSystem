package com.cg.fms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entites.Employee;
import com.cg.fms.entites.Program;


@Repository
public interface ITrainingProgramRepository extends CrudRepository<Program, String> {

	@Query("Select p from Program p where p.programId=?1")
	List<Program> findByProgramId(String programId);

	@Query("Select p from Program p where p.startDate=?1")
	List<Program> findByStartDate(LocalDate startDate);
	@Query("Select p from Program p where p.employee=?1")
	//List<Program> findByEmployee(int empid);
	List<Program> findByEmployee(Employee employee);
	
}