package com.rxlab.action.interview;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Knowledge;
import com.rxlab.pojo.Quiz;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.QuizService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class AddQuizAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	int q_id = 1;
	String ans = null;
	String comment = null;
	String question = null;
	String answer = null;
	
	public String execute() {
		System.out.println("q_id:"+q_id+" ans:"+ans+" comment:"+comment);
		System.out.println("answer:"+answer+" question:"+question);
		QuizService service = new InterviewServiceFactoryImpl();
		//System.out.println("quiz size:"+service.countQuiz("database"));
		KnowledgeService service1 = new InterviewServiceFactoryImpl();
		Knowledge k = service1.getKnowLedgeById(q_id);
		Quiz quiz = new Quiz(k, ans, comment);
		service.addQuiz(quiz);
		return "success";
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
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
	
}
