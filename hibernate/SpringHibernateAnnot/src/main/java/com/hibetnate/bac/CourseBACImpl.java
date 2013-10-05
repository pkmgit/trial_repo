package com.hibetnate.bac;

import java.util.List;

import com.hibernate.dao.CourseDao;
import com.hibernate.dao.CourseDaoImpl;
import com.hibernate.entity.Course;

public class CourseBACImpl implements CourseBAC {

	private CourseDao dao ;
	private CourseDao newCourseDao;

	
	@Override
	public void createCourseWithDetails(Course course) {

            dao.create(course);
		
	}
	
	
	
	
	@Override
	public void processCourse(List<Course> courses, int p) {

		dao.create(courses);
		
		List<Course> list = dao.findAll(); 
		System.out.println("The saved courses are --> " + list);
		
		
		
		newCourseDao.create(courses);
		
		if(p==-1){
			throw new RuntimeException("custom error");
		}

		
	}
	
	
	@Override
	public boolean coursesExist() {

		
		List<Course> newlist = newCourseDao.findAll(); 
		
		System.out.println("The new saved courses are --> " + newlist);
		
		
		return !newlist.isEmpty();
		
		
		
	}
	
	
	
	public void setDao(CourseDao dao) {
		this.dao = dao;
	}

	public void setNewCourseDao(CourseDao newCourseDao) {
		this.newCourseDao = newCourseDao;
	}

	
	
	
	
}
