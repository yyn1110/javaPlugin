package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCooperationuserAdd implements Serializable {
	private static final long serialVersionUID = 0X221B76D481023CF4L;
	private Integer id; // type in db: int(11)
	private String platform; // type in db: varchar(50)
	private String outUserId; // type in db: varchar(100)
	private String loginName; // type in db: varchar(100)
	private String realName; // type in db: varchar(1000)
	private String nickName; // type in db: varchar(1000)
	private String mobile; // type in db: varchar(200)
	private String telphone; // type in db: varchar(200)
	private String email; // type in db: varchar(200)
	private java.util.Date birthday; // type in db: datetime
	private String originalParameter; // type in db: tinytext
	private Integer kubaUserId; // type in db: int(11)
	private java.util.Date addTime; // type in db: datetime
	private Integer status; // type in db: int(11)
	private Integer gender; // type in db: int(11)
	private String userSafeKey; // type in db: varchar(50)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlatform() {
		return this.platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOutUserId() {
		return this.outUserId;
	}
	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
	}

	public String getLoginName() {
		return this.loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return this.realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelphone() {
		return this.telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getOriginalParameter() {
		return this.originalParameter;
	}
	public void setOriginalParameter(String originalParameter) {
		this.originalParameter = originalParameter;
	}

	public Integer getKubaUserId() {
		return this.kubaUserId;
	}
	public void setKubaUserId(Integer kubaUserId) {
		this.kubaUserId = kubaUserId;
	}

	public java.util.Date getAddTime() {
		return this.addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getGender() {
		return this.gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getUserSafeKey() {
		return this.userSafeKey;
	}
	public void setUserSafeKey(String userSafeKey) {
		this.userSafeKey = userSafeKey;
	}


	@Override
	public String toString() {
		return "EcuserCooperationuserAdd [id=" + id + ", platform=" + platform + ", outUserId=" + outUserId + ", loginName=" + loginName + ", realName=" + realName + ", nickName=" + nickName + ", mobile=" + mobile + ", telphone=" + telphone + ", email=" + email + ", birthday=" + birthday + ", originalParameter=" + originalParameter + ", kubaUserId=" + kubaUserId + ", addTime=" + addTime + ", status=" + status + ", gender=" + gender + ", userSafeKey=" + userSafeKey + "]";
	}
}
