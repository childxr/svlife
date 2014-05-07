package com.rxlab.pojo;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "coding")
public class Code implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="c_id")
	private int codingId;
	
	@Column(name="question")
	private String question;
	
	@Column(name="path")
	private String path;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	Date dateCreated;
	
	@Column(name="category")
	private String category;
	
	/*
	private ArrayList<CodeComment> comments = new ArrayList<CodeComment> ();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coding_comment")
	public ArrayList<CodeComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<CodeComment> comments) {
		this.comments = comments;
	}
	*/
	public int getCodingId() {
		return codingId;
	}
	public void setCodingId(int codingId) {
		this.codingId = codingId;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
