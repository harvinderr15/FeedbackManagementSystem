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

import com.cg.fms.dto.CourseDto;

import com.cg.fms.exception.CourseNotFoundException;

import com.cg.fms.service.ICourseManagementService;

@RestController
//RestController is used to create RESTful web services 
@RequestMapping("/api/course")
//This annotation maps HTTP requests to handler methods. Methods are mapped with /api/course
public class CourseController {
	@Autowired
	ICourseManagementService courseservice;

	// Method for adding course to database

	@PostMapping
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto coursedto) {
		return new ResponseEntity<CourseDto>(courseservice.addCourse(coursedto), HttpStatus.OK);
	}

	// Method for updating course in database

	@PutMapping
	public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto coursedto) {
		return new ResponseEntity<CourseDto>(courseservice.updateCourse(coursedto), HttpStatus.OK);
	}

	// Method for removing course by using course id if id not present then it will
	// throw Exception

	@DeleteMapping("/{courseId}")
	public ResponseEntity<CourseDto> removeCourse(@PathVariable("courseId") String id) throws CourseNotFoundException {
		return new ResponseEntity<CourseDto>(courseservice.removeCourse(id), HttpStatus.OK);
	}

	// Method for viewing course by using course id if id not present then it will
	// throw Exception

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> viewCourse(@PathVariable("courseId") String id) throws CourseNotFoundException {
		return new ResponseEntity<CourseDto>(courseservice.viewCourse(id), HttpStatus.OK);
	}

	// To list out all the courses present in database

	@GetMapping("/list")
	ResponseEntity<List<CourseDto>> viewAllCourses() {
		List<CourseDto> courselist = courseservice.viewAllCourses();
		ResponseEntity<List<CourseDto>> response = new ResponseEntity<List<CourseDto>>(courselist, HttpStatus.OK);
		return response;
	}

}