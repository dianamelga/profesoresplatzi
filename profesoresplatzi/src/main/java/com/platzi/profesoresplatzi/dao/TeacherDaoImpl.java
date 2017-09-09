package com.platzi.profesoresplatzi.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.profesoresplatzi.model.Teacher;
import com.platzi.profesoresplatzi.model.TeacherSocialMedia;


@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {
	
	public void saveTeacher(Teacher teacher) {
		// persist hace lo mismo que save, pero se recomienda persist
	
		getSession().persist(teacher);
	}

	public void deleteTeacherById(Long idTeacher) {
		// TODO Auto-generated method stub
		Teacher teacher = findById(idTeacher);
		if (teacher != null) {
			
			Iterator<TeacherSocialMedia> itTSM= teacher.getTeacherSocialMedia().iterator();
			
			while (itTSM.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = itTSM.next();
				itTSM.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(idTeacher);
			
			
		}
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().update(teacher);
		
	}

	public List<Teacher> findAllTeachers() {
		return getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().createQuery(
				"from Teacher where name = :name")
				.setParameter("name", name).uniqueResult();
	}
	

}
