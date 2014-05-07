package com.rxlab.action.interview;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Exam;
import com.rxlab.pojo.ExamTry;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class AddExamTryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String examId;
	private String yanswer;
	private String comment;
	
	public String execute() {
		InterviewServiceFactoryImpl service = new InterviewServiceFactoryImpl();
		Exam exam = service.getExamById(Integer.valueOf(examId));
		ExamTry examtry = new ExamTry(exam, yanswer, comment);
		service.addExamTry(examtry);
		return "success";
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
