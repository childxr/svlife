package com.rxlab.action.page;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.CodeComment;
import com.rxlab.service.interview.CodeCommentService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowCodeCommentPageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String codingId;
	private List<CodeComment> commentList = null;
	
	public String execute() {
		CodeCommentService codeCommentService = new InterviewServiceFactoryImpl();
		commentList = codeCommentService.getCodeCommentbyCodeId(Integer.valueOf(codingId));
		return "success";
	}

	public String getCodingId() {
		return codingId;
	}

	public void setCodingId(String codingId) {
		this.codingId = codingId;
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
	
	
}
