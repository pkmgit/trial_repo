package com.hibernate.bac;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.hibernate.entity.Course;
import com.hibernate.entity.CourseDetails;
import com.hibetnate.bac.CourseBAC;
import com.hibetnate.bac.CourseBACImpl;

public class CreateCourseService {

	
	private static int NO_ERROR = 0;
	private static int ERROR = -1;
	
	
	private CourseBAC courseBAC = null;

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

		Course c = new Course();
		c.setName("John2");
		c.setCourse("Java2");

		CourseDetails dt = new CourseDetails();
		dt.setDetails("details values");
		c.setDetails(dt);
        dt.setCourse(c);
		courseBAC.createCourseWithDetails(c);
		
		Assert.isTrue(courseBAC.coursesExist());
	}
	
	
	
}
