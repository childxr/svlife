package com.rxlab.pojo;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exam_try")
public class ExamTry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="et_id")
	private int examtryId;
	
	@ManyToOne(targetEntity = Exam.class)
    @JoinColumn(name = "e_id")
	private Exam exam;
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	@Column(name="yanswer")
	private String yanswer;
	
	@Column(name="comment")
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_created")
	private Date dateCreated;
	
	public ExamTry () {}
	
	public ExamTry(Exam exam, String yanswer, String comment) {
		this.exam = exam;
		this.yanswer = yanswer;
		this.comment = comment;
	}
	
	public ExamTry(Exam exam, String yanswer, String comment, Date dateCreated) {
		this.exam = exam;
		this.yanswer = yanswer;
		this.comment = comment;
		this.dateCreated = dateCreated;
	}
	
	public int getExamtryId() {
		return examtryId;
	}
	public void setExamtryId(int examtryId) {
		this.examtryId = examtryId;
	}
	public String getYanswer() {
		return yanswer;
	}
	public void setYanswer(String yanswer) {
		this.yanswer = yanswer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
