package com.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hibernate.entity.Course;

public class CourseDaoImpl extends HibernateDAOSupport implements CourseDao {

	@Override
	public void create(List<Course> listCourses) {
		HibernateTemplate template = this.getHibernateTemplate();
		for (Course course : listCourses) {
			template.save(course);
		}
	}

	@Override
	public List findAll() {
		return this.getHibernateTemplate().find("From Course");
	}

	@Override
	public void create(Course course) {
		this.getHibernateTemplate().save(course);
		
	}
	
	
}
