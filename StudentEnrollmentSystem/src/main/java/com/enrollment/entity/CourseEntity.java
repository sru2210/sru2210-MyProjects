package com.enrollment.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@ToString
@NoArgsConstructor
@Entity
@Table(name = "Course")
public class CourseEntity {
	@Id
	private String courseCode;
	@NotNull
	@Size(max = 50)
	private String courseName;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="semester",nullable=false)
	@JsonIgnore
	private SemesterEntity semester;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="deptId",nullable=false)
	@JsonIgnore
	private DepartmentEntity department;
	public CourseEntity(String courseCode, @NotNull @Size(max = 50) String courseName, SemesterEntity semester,
			DepartmentEntity department) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semester = semester;
		this.department = department;
	}
	@Override
	public String toString() {
		return "CourseEntity [courseCode=" + courseCode + ", courseName=" + courseName + "]";
	}
	
}
