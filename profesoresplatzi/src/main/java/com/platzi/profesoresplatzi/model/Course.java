package com.platzi.profesoresplatzi.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="course")
public class Course implements Serializable {

	@Id
	@Column(name="id_course")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCourse;
	
	@Column(name="name")
	private String name;

	@Column(name="theme")
	private String themes;
	
	@Column(name="project")
	private String project;
	
	
	//teacher es opcional por que es nulable
	@ManyToOne(optional = true)
	@JoinColumn(name="id_teacher")
	private Teacher teacher;
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String name, String themes, String project) {
		super();
		this.name = name;
		this.themes = themes;
		this.project = project;
		
	}
	public Long getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThemes() {
		return themes;
	}
	public void setThemes(String themes) {
		this.themes = themes;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
}