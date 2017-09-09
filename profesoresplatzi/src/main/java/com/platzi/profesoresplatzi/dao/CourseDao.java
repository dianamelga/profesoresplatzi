package com.platzi.profesoresplatzi.dao;
import com.platzi.profesoresplatzi.model.Course;
import com.platzi.profesoresplatzi.model.Teacher;
import java.util.List;

public interface CourseDao {
	
	void saveCourse(Course course);
	
	void deleteCourseById(Long idCourse);
	
	void updateCourse(Course course);
	
	List<Course> findAllCourses();
	
	Course findCourseById(Long idCourse);
	
	Course findCourseByName(String name);
	
	List<Course> findByIdTeacher(Long idTeacher);
	
	
}
