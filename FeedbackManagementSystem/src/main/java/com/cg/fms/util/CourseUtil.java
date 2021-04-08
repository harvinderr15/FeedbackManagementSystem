package com.cg.fms.util;


import java.util.ArrayList;
import java.util.List;

import com.cg.fms.dto.CourseDto;
import com.cg.fms.entites.Course;

public class CourseUtil {
	
	public static CourseDto toDto(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName( course.getCourseName() );
		courseDto.setCourseDescription(course.getCourseDescription());
		courseDto.setNoOfDays(course.getNoOfDays());
		return courseDto;
	}
	
	public static Course toEntity(CourseDto courseDto ) {
		Course course = new Course();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setCourseDescription(courseDto.getCourseDescription());
		course.setNoOfDays(courseDto.getNoOfDays());
		return course;
	}
	
	public static List<CourseDto> toDtoList(List<Course> courses){
		List<CourseDto> dtoList = new ArrayList<CourseDto>();
		
		// Pick each of the element of the argument products and convert it into DTO and store in dtoList
		for(Course course : courses) {
			dtoList.add( toDto(course) );
			
		}
		
		return dtoList;
	}

}
