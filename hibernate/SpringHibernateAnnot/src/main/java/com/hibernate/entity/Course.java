package com.hibernate.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;

/**
 * Model class for Stock
 */
@Entity
@Table(name = "course", catalog = "springhibchema", uniqueConstraints = {
		@UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "course") })
public class Course implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String course;
	private CourseDetails details;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name", unique = true, nullable = false, length = 10)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "course", unique = true, nullable = false, length = 20)
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)	
	public CourseDetails getDetails() {
		return details;
	}
	
	public void setDetails(CourseDetails details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", course=" + course
				+ "]";
	}
	
	
	
	
}
