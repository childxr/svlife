package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;

public class ShowExamPageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public String info = null;

	public String execute() {
		return "success";
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
