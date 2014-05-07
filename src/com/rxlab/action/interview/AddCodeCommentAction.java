package com.rxlab.action.interview;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;
import com.rxlab.pojo.Code;
import com.rxlab.pojo.CodeComment;

public class AddCodeCommentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String codingId;
	private String ccomment;
	private List<CodeComment> commentList = null;
	
	public String execute() {
		System.out.println(codingId+" "+ccomment);
		InterviewServiceFactoryImpl service = new InterviewServiceFactoryImpl();
		Code code = service.getCodeById(Integer.valueOf(codingId));
		CodeComment cm = new CodeComment(code, ccomment);
		service.addCodeComment(cm);
		commentList = service.getCodeCommentbyCodeId(Integer.valueOf(codingId));
		ccomment = null;
		return "success";
	}

	public String getCodingId() {
		return codingId;
	}

	public void setCodingId(String codingId) {
		this.codingId = codingId;
	}

	public String getCcomment() {
		return ccomment;
	}

	public void setCcomment(String ccomment) {
		this.ccomment = ccomment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CodeComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CodeComment> commentList) {
		this.commentList = commentList;
	}
	
	
}
