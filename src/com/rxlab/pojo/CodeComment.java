package com.rxlab.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "coding_comment")
public class CodeComment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public CodeComment () {}
	
	public CodeComment (Code code, String comment) {
		this.code = code;
		this.comment = comment;
		this.dateCreated = new Date();
	}
	
	@Id
	@Column(name="cm_id")
	private int cmId;
	
	@ManyToOne(targetEntity = Code.class)
    @JoinColumn(name = "c_id")
	private Code code;
	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
	
	@Column(name="comment")
	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name="date")
	Date dateCreated;

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
