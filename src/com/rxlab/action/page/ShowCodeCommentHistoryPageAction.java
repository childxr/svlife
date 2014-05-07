package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.CodeComment;
import com.rxlab.service.interview.CodeCommentService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;
import java.util.List;
import java.util.ArrayList;

public class ShowCodeCommentHistoryPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int page;
	private String category;
	private List<CodeComment> commentList = null;
	private List<Integer> pages = null;
	
	public ShowCodeCommentHistoryPageAction () {
		pages = new ArrayList<Integer> ();
	}

	public String execute() {
		CodeCommentService service = new InterviewServiceFactoryImpl();
		if (category.equals("all")) {
			category = null;
		}
		int count = service.countCodeComment(category);
		
		commentList = service.listCodeCommentHistoryByPage(page, 50, count, category);
		int i = 1, iter = count/50;
		for(i = 1; i <= iter; i++) pages.add(i);
		if (count%50 > 0) pages.add(i);
		return "success";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<CodeComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CodeComment> commentList) {
		this.commentList = commentList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
