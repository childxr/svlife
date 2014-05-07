package com.rxlab.action.page;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.service.interview.CategoryService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowReviewPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<String> categoryList = null;
	private String category = null;
	private String info = null;
	
	public String execute() {
		//System.out.println("here!!!");
		CategoryService service = new InterviewServiceFactoryImpl();
		categoryList = service.getAllKnowledgeCategories();
		//for (String s: categoryList) System.out.println(s);
		return "success";
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
