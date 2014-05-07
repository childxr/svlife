package com.rxlab.action.page;

import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.rxlab.pojo.Code;
//import com.rxlab.help.config.Config;
import com.rxlab.service.interview.CodeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class ShowCodeDetailsPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String codingId;
	private Code code;
	private ArrayList<String> description = new ArrayList<String> ();
	private ArrayList<String> idea = new ArrayList<String> ();
	private String picPath;
	public String execute () {
		CodeService codeService =new InterviewServiceFactoryImpl();
		code = codeService.getCodeById(Integer.valueOf(codingId));
		HttpServletRequest request = ServletActionContext.getRequest();  
		String contextPath = request.getSession().getServletContext().getRealPath("//");   
		picPath = "codeimg\\"+code.getPath().replace("txt", "png");
		String path = contextPath+"/code/"+code.getPath();
		//String path = Config.getSystemizedPath("code", contextPath)+code.getPath();
		System.out.println(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader (new FileInputStream (new File (path)),"UTF-8"));
			String line = null;
			boolean des = false;
			while ((line = br.readLine())!= null) {
				if (line.startsWith("/*")) des = true;
				else if (line.startsWith("*")) des = false;
				else if (des) {
					description.add(line);
				} 
				else if (line.startsWith("//")) idea.add(line);
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		} 

		return "success";
	}
	public String getCodingId() {
		return codingId;
	}
	public void setCodingId(String codingId) {
		this.codingId = codingId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}
	public ArrayList<String> getDescription() {
		return description;
	}
	public void setDescription(ArrayList<String> description) {
		this.description = description;
	}

	public ArrayList<String> getIdea() {
		return idea;
	}
	public void setIdea(ArrayList<String> idea) {
		this.idea = idea;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
}
