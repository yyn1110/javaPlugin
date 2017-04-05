package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinTemplate implements Serializable {
	private static final long serialVersionUID = 0XAD21A921BDA84BF3L;
	private Integer templateId; // type in db: int(20)
	private String templateContent; // type in db: varchar(4000)
	private String templateType; // type in db: varchar(20)
	private String inputer; // type in db: varchar(50)
	private java.util.Date inputeDate; // type in db: datetime
	private Double price; // type in db: double(10,2)

	public Integer getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTemplateContent() {
		return this.templateContent;
	}
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getTemplateType() {
		return this.templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getInputer() {
		return this.inputer;
	}
	public void setInputer(String inputer) {
		this.inputer = inputer;
	}

	public java.util.Date getInputeDate() {
		return this.inputeDate;
	}
	public void setInputeDate(java.util.Date inputeDate) {
		this.inputeDate = inputeDate;
	}

	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "WeixinTemplate [templateId=" + templateId + ", templateContent=" + templateContent + ", templateType=" + templateType + ", inputer=" + inputer + ", inputeDate=" + inputeDate + ", price=" + price + "]";
	}
}
