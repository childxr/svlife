package com.rxlab.action.interview;

import com.opensymphony.xwork2.ActionSupport;

import com.rxlab.pojo.Knowledge;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class AddKnowledgeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String question = null;
	private String category = null;
	private String answer = null;
	
	public String execute() {
		System.out.println("FORM ACTION!");
		Knowledge knowledge = new Knowledge(question, answer, category);
		KnowledgeService service = new InterviewServiceFactoryImpl();
		service.addKnowledge(knowledge);
		return "success";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
