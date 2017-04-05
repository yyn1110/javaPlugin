package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserUpdateuserauthinfologs implements Serializable {
	private static final long serialVersionUID = 0X979C705146294E24L;
	private Integer id; // type in db: int(20)
	private String operator; // type in db: varchar(50)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private Integer type; // type in db: int(5) unsigned zerofill
	private java.util.Date date; // type in db: datetime
	private String content; // type in db: varchar(200)
	private String userLoginEmail; // type in db: varchar(250)
	private String userLoginMobile; // type in db: varchar(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperator() {
		return this.operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getUserLoginEmail() {
		return this.userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}

	public String getUserLoginMobile() {
		return this.userLoginMobile;
	}
	public void setUserLoginMobile(String userLoginMobile) {
		this.userLoginMobile = userLoginMobile;
	}


	@Override
	public String toString() {
		return "EcuserUpdateuserauthinfologs [id=" + id + ", operator=" + operator + ", userId=" + userId + ", userName=" + userName + ", type=" + type + ", date=" + date + ", content=" + content + ", userLoginEmail=" + userLoginEmail + ", userLoginMobile=" + userLoginMobile + "]";
	}
}
