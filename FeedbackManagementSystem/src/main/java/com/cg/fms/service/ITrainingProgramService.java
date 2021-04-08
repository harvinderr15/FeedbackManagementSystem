package com.cg.fms.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entites.Employee;
import com.cg.fms.entites.Program;
import com.cg.fms.repository.ITrainingProgramRepository;


@Service
public class ITrainingProgramService {
	@Autowired
	ITrainingProgramRepository repo;
	
	
	public Program createProgram(Program program)
	{
		
		return repo.save(program);
	}
	public Program updateProgram(Program program)
	{
		return repo.save(program);
	}
	public void removeProgram(String id)
	{
		repo.deleteById(id);
	}
	public Optional<Program> viewProgram(String id)
	{
		return repo.findById(id);
//		Program program= (Program) temp;
//		return program;
//		
	}
	
		
	
	public List<Program> viewAllProgramsList() {
		Iterable<Program> iprograms= repo.findAll();
		List<Program> programs= new ArrayList<>();
		for (Program pr :iprograms) {
			programs.add(pr);
		}
		return programs;
	}
	public List<Program> viewAllById(String programId)
	{
		return repo.findByProgramId(programId);
	}
	public List<Program> viewAllByDate(String sdate) throws ParseException
	{
		LocalDate date= LocalDate.parse(sdate);
		return repo.findByStartDate(date);
	}
	
	public List<Program> viewAllByFaculty(String id)
	{
		Employee emp= new Employee();
		emp.setEmployeeId(Integer.parseInt(id));
		return repo.findByEmployee(emp);
	}
}
