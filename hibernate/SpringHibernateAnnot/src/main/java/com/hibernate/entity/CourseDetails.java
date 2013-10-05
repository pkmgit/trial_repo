package com.hibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Model class for Stock
 */
@Entity
@Table(name = "coursedetails", catalog = "springhibchema")
public class CourseDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String details;
	private Course course;
	
	
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "course"))
	@GeneratedValue(generator = "generator")
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Column(name = "details", unique = true, nullable = false)
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	
	
}
