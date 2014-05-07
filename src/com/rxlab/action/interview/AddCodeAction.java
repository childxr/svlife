package com.rxlab.action.interview;

import java.io.File;
import java.util.Date;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rxlab.pojo.Code;
//import com.rxlab.help.config.Config;
import com.rxlab.service.interview.CodeService;
import com.rxlab.service.interview.impl.InterviewServiceFactoryImpl;

public class AddCodeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String cat;
	
	private File imageFile;
	private String imageFileFileName;
	private String imageFileContentType;
	private File texFile;
	private String texFileFileName;
	private String texFileContentType;
	
	public String execute() {
		System.out.println("Add Code!!!");
		System.out.println(cat);
		System.out.println(title);
		System.out.println(texFileFileName);
		HttpServletRequest request = ServletActionContext.getRequest();  
		String contextPath = request.getSession().getServletContext().getRealPath("//");  
		System.out.println(contextPath);
		//String imgPath = Config.getSystemizedPath("codeimg", contextPath);
		//String texPath = Config.getSystemizedPath("code", contextPath);
		//unix
		String imgPath = contextPath+"/codeimg/";
		String texPath = contextPath+"/code/";
		
		try {
			File texDestFile = new File(texPath, texFileFileName);
			File imgDestFile  = new File(imgPath, imageFileFileName);			
			FileUtils.copyFile(texFile, texDestFile);
		    FileUtils.copyFile(imageFile, imgDestFile);		    
		    Code code = new Code();
		    code.setCategory(cat);
		    code.setPath(texFileFileName);
		    code.setQuestion(title);
		    code.setDateCreated(new Date());
			CodeService service = new InterviewServiceFactoryImpl();
			service.addCode(code);
		} catch(IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getImageFile() {
		return imageFile;
	}
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}
	public String getImageFileFileName() {
		return imageFileFileName;
	}
	public void setImageFileFileName(String imageFileFileName) {
		this.imageFileFileName = imageFileFileName;
	}
	public File getTexFile() {
		return texFile;
	}
	public void setTexFile(File texFile) {
		this.texFile = texFile;
	}
	public String getTexFileFileName() {
		return texFileFileName;
	}
	public void setTexFileFileName(String texFileFileName) {
		this.texFileFileName = texFileFileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getImageFileContentType() {
		return imageFileContentType;
	}

	public void setImageFileContentType(String imageFileContentType) {
		this.imageFileContentType = imageFileContentType;
	}

	public String getTexFileContentType() {
		return texFileContentType;
	}

	public void setTexFileContentType(String texFileContentType) {
		this.texFileContentType = texFileContentType;
	}

}
