package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

import com.rxlab.pojo.Exam;
import com.rxlab.service.interview.ExamService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowExamTryPageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String examId;
	private ArrayList<String> questionContent = new ArrayList<String> ();
	private ArrayList<String> optionsContent = new ArrayList<String> ();
	private String category;
	private String answer;
	
	public String execute() {
		ExamService service = new InterviewServiceFactoryImpl();
		System.out.println("exam id:"+examId);
		int count = service.countExam();
		if (Integer.valueOf(examId) >= count) return "end";
		Exam exam = service.getExamById(Integer.valueOf(examId)+1);
		examId = String.valueOf(exam.getExamId());
		String question = exam.getQuestion();
		category = exam.getCategory();
		answer = exam.getAnswer();
		String options = exam.getOptions();
		String[] strs = question.split("\n");
		for (String str: strs) questionContent.add(str);
		strs = options.split("\n");
		for (String str: strs) optionsContent.add(str);

		return "success";
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
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

	public ArrayList<String> getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(ArrayList<String> questionContent) {
		this.questionContent = questionContent;
	}

	public ArrayList<String> getOptionsContent() {
		return optionsContent;
	}

	public void setOptionsContent(ArrayList<String> optionsContent) {
		this.optionsContent = optionsContent;
	}
	
	
}
