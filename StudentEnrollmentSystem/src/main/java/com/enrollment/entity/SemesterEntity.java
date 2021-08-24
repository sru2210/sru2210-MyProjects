package com.enrollment.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
//@ToString
@Entity
@Table(name="Semester")
public class SemesterEntity {
	@Id
	@Column(unique=true,nullable=false)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@OneToMany(mappedBy="semester",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<CourseEntity> courses;
	public SemesterEntity(Long id, Date beginDate, Date endDate) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "SemesterEntity [id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
	}
	
}
