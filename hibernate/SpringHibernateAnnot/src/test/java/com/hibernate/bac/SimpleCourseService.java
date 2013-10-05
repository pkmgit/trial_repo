package com.hibernate.bac;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.hibernate.entity.Course;
import com.hibetnate.bac.CourseBAC;
import com.hibetnate.bac.CourseBACImpl;

public class SimpleCourseService {

	
	private static int NO_ERROR = 0;
	private static int ERROR = -1;
	
	
	CourseBAC courseBAC = null;

	@Before
	public void setUp() throws Exception {

		courseBAC = new CourseBACImpl(); // tightly coupled

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		courseBAC = (CourseBAC) context.getBean("courseBAC");

	}

	@Test
	public void testProcessCourse() {
		process();
	}



	private void process() {
		List<Course> courses = new ArrayList<Course>(10);
		Course c11 = new Course();
		c11.setName("John2");
		c11.setCourse("Java2");
		courses.add(c11);
		Course c12 = new Course();
		c12.setName("Peter2");
		c12.setCourse("Hibernate2");
		courses.add(c12);
		courseBAC.processCourse(courses,SimpleCourseService.NO_ERROR);
		
		Assert.isTrue(courseBAC.coursesExist());
	}
	
	
	
}
