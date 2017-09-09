package com.platzi.profesoresplatzi.dao;

import java.util.List;

import com.platzi.profesoresplatzi.model.Course;
import com.platzi.profesoresplatzi.model.Teacher;

public class CourseDaoImpl extends AbstractSession implements CourseDao{

	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().persist(course);
		
	}

	public void deleteCourseById(Long idCourse) {
		// TODO Auto-generated method stub
		Course course = findCourseById(idCourse);
		if (course != null) {
			getSession().delete(course);
		}
		
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().update(course);
		
	}

	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Course").list();
	}

	public Course findCourseById(Long idCourse) {
		// TODO Auto-generated method stub
		return getSession().get(Course.class, idCourse);
		
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery(
				"from Course where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> findByIdTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery(
				"from Course c join c.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}
}