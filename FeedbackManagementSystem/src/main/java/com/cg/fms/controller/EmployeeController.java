package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fms.dto.EmployeeDto;
import com.cg.fms.entites.Employee;
import com.cg.fms.exception.TrainerNotFoundException;
import com.cg.fms.service.ITrainerManagementService;
import com.cg.fms.util.EmployeeUtil;

@RestController
//RestController is used to create RESTful web services 
@RequestMapping("/api/emp")
//This annotation maps HTTP requests to handler methods. Methods are mapped with /api/emp
public class EmployeeController {
	@Autowired

	ITrainerManagementService service; // service object is created and annotated with Autowired

	@PostMapping("")
	// Mapping the addTrainer method to add data into database
	public ResponseEntity<EmployeeDto> addTrainer(@RequestBody EmployeeDto empdto) {
		return new ResponseEntity<EmployeeDto>(service.addTrainer(empdto), HttpStatus.OK);
	}

	@PutMapping
	// Mapping the updateTrainer method to update data into database
	public ResponseEntity<EmployeeDto> updateTrainer(@RequestBody EmployeeDto empdto) {
		return new ResponseEntity<EmployeeDto>(service.updateTrainer(empdto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	// Mapping with Delete to delete the data form the database using ID as
	// identifier
	public ResponseEntity<EmployeeDto> removeTrainer(@PathVariable("id") int id) throws TrainerNotFoundException {
		return new ResponseEntity<EmployeeDto>(service.removeTrainer(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	// Getting Trainer data using id as identifier
	public ResponseEntity<EmployeeDto> viewTrainer(@PathVariable("id") int id) throws TrainerNotFoundException {
		return new ResponseEntity<EmployeeDto>(service.viewTrainer(id), HttpStatus.OK);
	}

	@GetMapping("/skills/{Skills}")
	// mapping the method to get the list of trainers with specific skill set
	public ResponseEntity<List<EmployeeDto>> viewAllTrainers(@PathVariable("Skills") String skill)
			throws TrainerNotFoundException {
		List<Employee> elist = service.viewAllTrainers(skill);
		List<EmployeeDto> dtolist = EmployeeUtil.toDtoList(elist);
		ResponseEntity<List<EmployeeDto>> response = new ResponseEntity<List<EmployeeDto>>(dtolist, HttpStatus.OK);
		return response;
	}

	@GetMapping("/viewall")
	// mapping to method to get the list of all Trainers
	ResponseEntity<List<EmployeeDto>> viewAllTrainers() {
		List<EmployeeDto> elist = service.viewAllTrainers();
		ResponseEntity<List<EmployeeDto>> response = new ResponseEntity<List<EmployeeDto>>(elist, HttpStatus.OK);
		return response;
	}

}
