package com.platzi.profesoresplatzi.service;

import java.util.List;

import com.platzi.profesoresplatzi.model.Course;

public interface CourseService {

	void saveCourse(Course course);
	
	void deleteCourseById(Long idCourse);
	
	void updateCourse(Course course);
	
	List<Course> findAllCourses();
	
	Course findCourseById(Long idCourse);
	
	Course findCourseByName(String name);
	
	List<Course> findByIdTeacher(Long idTeacher);
	
}
