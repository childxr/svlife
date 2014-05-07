package com.rxlab.action.page;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Quiz;
import com.rxlab.pojo.Knowledge;
import com.rxlab.service.interview.QuizService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowQuizHistoryPageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String category = null;
	private List<Quiz> quizList = null;
	private List<Integer> pages = null;
	private String page = null;
	
	public ShowQuizHistoryPageAction () {
		pages = new ArrayList<Integer> ();
	}
	
	public String execute() {
		QuizService service = new InterviewServiceFactoryImpl();
		if (category.equals("all")) category = null;
		int count = service.countQuiz(category);
		quizList = service.getQuizByPage(category, 20, Integer.valueOf(page), count);
		for (Quiz q: quizList) {
			String answer = q.getAnswer();
			String[] ans = answer.split("\n");
			StringBuffer bf = new StringBuffer();
			for (String a: ans) {
				bf.append("<p>"+a+"</p>");
			}
			q.setAnswer(bf.toString());
			Knowledge k = q.getKnowledge();
			answer = k.getAnswer();
			ans = answer.split("\n");
			bf = new StringBuffer();
			for (String a: ans) {
				bf.append("<p>"+a+"</p>");
			}
			k.setAnswer(bf.toString());
		}
		int i = 1, iter = count/20;
		for(i = 1; i <= iter; i++) pages.add(i);
		if (count%20 > 0) pages.add(i);
		return "success";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
