package com.rxlab.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knowledge")
public class Knowledge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="k_id")
	private int knowledgeId;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer;
	@Column(name="category")
	private String category;
	
	public Knowledge() {
		
	}
	public Knowledge(String question, String answer, String category) {
		this.question = question;
		this.answer = answer;
		this.category = category;
	}

	public int getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(int knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
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
	
}
