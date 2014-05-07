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
@Table(name = "quiz")
public class Quiz implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Quiz () {
	}
	
	public Quiz (Knowledge knowledge, String answer, String comment) {
		this.knowledge = knowledge;
		this.answer = answer;
		this.comment = comment;
		this.timeCreated = new Date();
	}

	@Id
	@Column(name="q_id")
	private int qId;
	
	@ManyToOne(targetEntity = Knowledge.class)
    @JoinColumn(name = "k_id")
	private Knowledge knowledge;
	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}
	
	@Column(name="answer")
	private String answer;
	
	@Column(name="comment")
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_created")
	Date timeCreated;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	
}
