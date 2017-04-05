package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinKeywordTemplate implements Serializable {
	private static final long serialVersionUID = 0X15FE66C64298F9B5L;
	private Integer id; // type in db: int(20)
	private Integer keyWordId; // type in db: int(20)
	private Integer templateId; // type in db: int(20)
	private java.util.Date inputeDate; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKeyWordId() {
		return this.keyWordId;
	}
	public void setKeyWordId(Integer keyWordId) {
		this.keyWordId = keyWordId;
	}

	public Integer getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public java.util.Date getInputeDate() {
		return this.inputeDate;
	}
	public void setInputeDate(java.util.Date inputeDate) {
		this.inputeDate = inputeDate;
	}


	@Override
	public String toString() {
		return "WeixinKeywordTemplate [id=" + id + ", keyWordId=" + keyWordId + ", templateId=" + templateId + ", inputeDate=" + inputeDate + "]";
	}
}
