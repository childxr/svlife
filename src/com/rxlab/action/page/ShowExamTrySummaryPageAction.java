package com.rxlab.action.page;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.ExamTry;
import com.rxlab.pojo.Exam;
import com.rxlab.service.interview.ExamTryService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowExamTrySummaryPageAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String page = null;
	private List<ExamTry> examtryList = null;
	private List<Integer> pages = null;
	
	public ShowExamTrySummaryPageAction () {
		pages = new ArrayList<Integer> ();
	}
	
	public String execute () {
		ExamTryService service = new InterviewServiceFactoryImpl();
		int count = service.countExamTry();
		examtryList = service.getExamTryByPage(50, count, Integer.valueOf(page));
		for(ExamTry examtry: examtryList) {
			Exam exam = examtry.getExam();
			String option = exam.getOptions();
			String question = exam.getQuestion();
			String[] options = option.split("\n");
			String[] questions = question.split("\n");
			StringBuffer bf = new StringBuffer();
			StringBuffer bf1 = new StringBuffer();
			for (String str: options) {
				bf.append("<p>"+str+"</p>");
			}
			for (String str: questions) {
				bf1.append("<p>"+str+"</p>");
			}
			exam.setOptions(bf.toString());
			exam.setQuestion(bf1.toString());
		}
		int i = 1, iter = count/50;
		for(i = 1; i <= iter; i++) pages.add(i);
		if (count%50 > 0) pages.add(i);
		return "success";
		
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<ExamTry> getExamtryList() {
		return examtryList;
	}

	public void setExamtryList(List<ExamTry> examtryList) {
		this.examtryList = examtryList;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
