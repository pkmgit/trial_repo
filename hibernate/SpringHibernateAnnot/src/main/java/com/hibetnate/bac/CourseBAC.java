package com.hibetnate.bac;

import java.util.List;

import com.hibernate.entity.Course;

public interface CourseBAC {

    void processCourse(List<Course> courses, int p);

	boolean coursesExist();

	void createCourseWithDetails(Course course);
}
