package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Course;

public interface CourseDao {
	public abstract void create(List<Course> listCourses); 
	public abstract List findAll( );
	public abstract void create(Course course);
}
