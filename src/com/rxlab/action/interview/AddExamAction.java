package com.rxlab.action.interview;

import com.opensymphony.xwork2.ActionSupport;

import com.rxlab.pojo.Exam;
import com.rxlab.service.interview.ExamService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class AddExamAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String question;
	private String answer;
	private String category;
	private String options;
	
	public String execute() {
		System.out.println(options);
		Exam exam = new Exam(question, answer, category, options);
		ExamService service = new InterviewServiceFactoryImpl();
		service.addExam(exam);
		return "success";
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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
