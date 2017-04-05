package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinShopTemplate implements Serializable {
	private static final long serialVersionUID = 0XB57FBFD44A028D08L;
	private Integer id; // type in db: int(20)
	private Integer shopId; // type in db: int(20)
	private Integer templateId; // type in db: int(20)
	private java.util.Date expire; // type in db: datetime
	private Integer templateStatus; // type in db: int(4)
	private Integer ifFillTemplate; // type in db: int(2)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopId() {
		return this.shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public java.util.Date getExpire() {
		return this.expire;
	}
	public void setExpire(java.util.Date expire) {
		this.expire = expire;
	}

	public Integer getTemplateStatus() {
		return this.templateStatus;
	}
	public void setTemplateStatus(Integer templateStatus) {
		this.templateStatus = templateStatus;
	}

	public Integer getIfFillTemplate() {
		return this.ifFillTemplate;
	}
	public void setIfFillTemplate(Integer ifFillTemplate) {
		this.ifFillTemplate = ifFillTemplate;
	}


	@Override
	public String toString() {
		return "WeixinShopTemplate [id=" + id + ", shopId=" + shopId + ", templateId=" + templateId + ", expire=" + expire + ", templateStatus=" + templateStatus + ", ifFillTemplate=" + ifFillTemplate + "]";
	}
}
