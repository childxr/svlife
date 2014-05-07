package com.rxlab.action.interview;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Knowledge;
import com.rxlab.service.interview.KnowledgeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ListKnowledgeQuestionAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private List<Knowledge> knowledgeList = null;
	
	public String execute() {
		KnowledgeService service = new InterviewServiceFactoryImpl();
		knowledgeList = service.getAllKnowledge();
		return "success";
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
	
	
}
