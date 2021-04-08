package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.CourseDto;

import com.cg.fms.entites.Course;

import com.cg.fms.exception.CourseNotFoundException;

import com.cg.fms.repository.ICourseManagementRepository;
import com.cg.fms.util.CourseUtil;


@Service
public class ICourseManagementService {
	
	@Autowired
	ICourseManagementRepository repo;

	/*public CourseDto getCourse(String id) throws CourseNotFoundException {
		Optional<Course> courseOpt = repo.findById(id);
		if (courseOpt.isPresent()) {
			Course c = courseOpt.get();
			return CourseUtil.toDto(c);
		} else {
			throw new CourseNotFoundException("Employee with id " + id + " Not Found");
		}
	}*/

	public CourseDto addCourse(CourseDto coursedto) {
		Course course = CourseUtil.toEntity(coursedto);
		Course coursesaved = repo.save(course);
		return CourseUtil.toDto(coursesaved);

	}

	public CourseDto updateCourse(CourseDto coursedto) {
		Course course = CourseUtil.toEntity(coursedto);
		Course coursesaved = repo.save(course);
		return CourseUtil.toDto(coursesaved);

	}


	public CourseDto removeCourse(String id) throws CourseNotFoundException {
		//String id = courseemp.getCourseId();
		Optional<Course> courseOpt = repo.findById(id);
		Course course = courseOpt.get();
		if(courseOpt.isPresent()) 
		{
			repo.delete(course);
			return CourseUtil.toDto(course);
		}else {
			throw new CourseNotFoundException();
		}

	}
	
	public CourseDto viewCourse(String id) throws CourseNotFoundException {

		Optional<Course> courseOpt = repo.findById(id);
		if (courseOpt.isPresent()) {
                 Course course = courseOpt.get();
                 return CourseUtil.toDto(course);
		}else {
			throw new CourseNotFoundException("Course not found ");
		}
	}
	/*public CourseDto viewCourse(Course course) {

		CourseDto coursedto = CourseUtil.toDto(course);
		System.out.println(coursedto);
		return coursedto;
	}*/

	/*public List<Course> viewAllCourses(Course course) throws CourseNotFoundException {
		@SuppressWarnings("unchecked")
		List<Course> courses = (List<Course>) repo.viewallCourses(course);
		if (courses.isEmpty()) {
			throw new CourseNotFoundException("These Course doesn't exist");
		} else {
			return courses;
		}
	}*/

	public List<CourseDto> viewAllCourses() {

		List<Course> courses = repo.findAll();
		List<CourseDto> courselist = CourseUtil.toDtoList(courses);
		return courselist;

	}

}
