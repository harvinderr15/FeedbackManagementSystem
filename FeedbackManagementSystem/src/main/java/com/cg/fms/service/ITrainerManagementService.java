package com.cg.fms.service;

import com.cg.fms.dto.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entites.Employee;
import com.cg.fms.exception.TrainerNotFoundException;
import com.cg.fms.repository.ITrainerManagementRepository;
import com.cg.fms.util.EmployeeUtil;

@Service
public class ITrainerManagementService {
	@Autowired
	ITrainerManagementRepository repo;

/*	public EmployeeDto getEmployee(int id) throws TrainerNotFoundException {
		Optional<Employee> empOpt = repo.findById(id);
		if (empOpt.isPresent()) {
			Employee emp = empOpt.get();
			return EmployeeUtil.toDto(emp);
		} else {
			throw new TrainerNotFoundException("Employee with id " + id + " Not Found");
		}
	}*/

	public EmployeeDto addTrainer(EmployeeDto empdto) {
		//System.out.println("EmployeeDto :"+ empdto.getSkills());
		Employee emp = EmployeeUtil.toEntity(empdto);
		Employee empsaved = repo.save(emp);
		//System.out.println("Inserting into table :"+ emp.getSkills());
		return EmployeeUtil.toDto(empsaved);

	}

	public EmployeeDto updateTrainer(EmployeeDto empdto) {
		Employee emp = EmployeeUtil.toEntity(empdto);
		Employee empsaved = repo.save(emp);
		return EmployeeUtil.toDto(empsaved);

	}

	public EmployeeDto removeTrainer(int id) throws TrainerNotFoundException {
		Optional<Employee> empOpt = repo.findById(id);
		Employee employee = empOpt.get();
		if(empOpt.isPresent()) 
		{
			repo.delete(employee);
			return EmployeeUtil.toDto(employee);
		}else {
			throw new TrainerNotFoundException();
		}

	}

	public EmployeeDto viewTrainer(int id) throws TrainerNotFoundException {
		//System.out.println("id is: "+id);
		Optional<Employee> empOpt = repo.findById(id);
		if (empOpt.isPresent()) {
                 Employee employee = empOpt.get();
                 return EmployeeUtil.toDto(employee);
		}else {
			throw new TrainerNotFoundException("Trainer not found ");
		}
	}

	public List<Employee> viewAllTrainers(String skill) throws TrainerNotFoundException {
		List<Employee> employees = repo.viewAllTrainers(skill);
		if (employees.isEmpty()) {
			throw new TrainerNotFoundException("Employee with these skills doesn't exist");
		} else {
			return employees;
		}
	}

	public List<EmployeeDto> viewAllTrainers() {

		List<Employee> emps = repo.findAll();
		List<EmployeeDto> trainerlist = EmployeeUtil.toDtoList(emps);
		return trainerlist;

	}

}
