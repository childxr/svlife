package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

public class ShowCodeListPageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> category = new ArrayList<String> ();
	String info = "false";
	public String execute() {
		category.add("linked list");
		category.add("array");
		category.add("queue");
		category.add("stack");
		category.add("string");
		category.add("tree");
		category.add("graph");
		category.add("hash table");
		category.add("recursion");
		category.add("greedy");
		category.add("bit manipulation");
		category.add("sorting");
		category.add("search");
		category.add("math");
		category.add("dynamic programming");
		return "success";
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
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
