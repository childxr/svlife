package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Knowledge;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowQuizPageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String category = null;
	private Integer id = null;
	private String question = null;
	private String answer = null;
	
	public String execute() {
		category = (category.equals("all")) ? null: category;
		KnowledgeService service = new InterviewServiceFactoryImpl();
		Knowledge knowledge = service.getRandomKnowledge(category);
		id = knowledge.getKnowledgeId();
		question = knowledge.getQuestion();
		answer = knowledge.getAnswer();
		return "success";
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
