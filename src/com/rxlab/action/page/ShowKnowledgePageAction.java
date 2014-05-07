package com.rxlab.action.page;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Knowledge;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowKnowledgePageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String category = null;
	private List<Knowledge> knowledgeList = null;
	private List<Integer> pages = null;
	private String page = null;
	
	public ShowKnowledgePageAction() {
		pages = new ArrayList<Integer> ();
	}
	
	public String execute() {
		System.out.println("knowledge action");
		category = (category.equals("all")) ? null: category;
		KnowledgeService service = new InterviewServiceFactoryImpl();
		int count = service.countAllKnowledge(category);
		knowledgeList = service.getAllKnowledgeByPage(category, 20, Integer.valueOf(page), count);
		for (Knowledge k: knowledgeList) {
			String answer = k.getAnswer();
			String[] ans = answer.split("\n");
			StringBuffer bf = new StringBuffer();
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
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
