package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import com.rxlab.pojo.Code;
import com.rxlab.service.interview.CodeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowAllCodePageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	public List<Code> codeList;
	public String category = null;
	
	public ShowAllCodePageAction () {
	}
	
	public String execute () {
		CodeService codeService = new InterviewServiceFactoryImpl();
		if (category.equals("all")) category = null;
		codeList = codeService.getAllCode(category);
		return "success";
	}

	public List<Code> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<Code> codeList) {
		this.codeList = codeList;
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
}
