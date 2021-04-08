package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entites.Course;


public interface ICourseManagementRepository  extends JpaRepository<Course, String>{

	//public Course addCourse(Course course);
	//public Course updateCourse(Course course);
	//public Course removeCourse(Course course);
	//public Course viewCourse(Course course);
	//public Course viewAllCourses(Course course);
	//public List<Course> viewAllCourses();
	
}
