package com.cg.fms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entites.Program;
import com.cg.fms.service.ITrainingProgramService;

@RestController
@RequestMapping("/api/program")
//Use to handle HTTP Request and Methods of this class mapped with /api/program
public class ITrainingProgramCollector {
	@Autowired
	ITrainingProgramService serve; //Service object is created and annotated with autowired

	@PostMapping("/add")
	//createProgram mapped with /api/program/add
	public Program createProgram(@RequestBody Program program) {

		return serve.createProgram(program);
	}

	@PutMapping("/update")
	//updateProgram mapped with /api/program/update
	public Program updateProgram(@RequestBody Program program) {
		return serve.updateProgram(program);
	}

	@DeleteMapping("/delete/{id}")
	/*removeProgram is mapped with /api/program/delete/{id}. here, {id} helps to identify the 
	 * program to be removed*/
	public void removeProgram(@PathVariable String id) {

		serve.removeProgram(id);
	}

	@GetMapping("/view/{id}")
	//it will return Optional<program>. Optional is a container object used to contain not-null objects.
	public Optional<Program> viewProgram(@PathVariable String id) {
		return serve.viewProgram(id);

	}

	@GetMapping("/list")
	//It is mapped with /api/program/list and it will return the list of all program
	public List<Program> viewAllProgramsList() {
		return serve.viewAllProgramsList();

	}

	@GetMapping("/views/{programId}")
	public List<Program> viewAllById(@PathVariable String programId) {
		return serve.viewAllById(programId);
	}

	@GetMapping("/bydate/{date}")
	//This method will use to retrieve the list of program by using date and it throws ParseException
	public List<Program> viewAllByDate(@PathVariable String date) throws java.text.ParseException {

		return serve.viewAllByDate(date);
	}

	@GetMapping("/empid/{id}")
	//Method will return the list of program according to Faculty id
	public List<Program> viewAllByFaculty(@PathVariable String id) {

		return serve.viewAllByFaculty(id);
	}
}
