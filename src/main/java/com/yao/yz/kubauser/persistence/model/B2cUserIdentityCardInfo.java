package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class B2cUserIdentityCardInfo implements Serializable {
	private static final long serialVersionUID = 0XF82C4210352C1C42L;
	private Integer id; // type in db: bigint(20) unsigned
	private Integer ecUserId; // type in db: int(11)
	private String userName; // type in db: varchar(200)
	private String identityName; // type in db: varchar(200)
	private String identityCard; // type in db: varchar(30)
	private String identityObverseImg; // type in db: varchar(250)
	private String identityReverseImg; // type in db: varchar(250)
	private String createUserId; // type in db: varchar(200)
	private java.util.Date createDate; // type in db: datetime
	private String updateUserId; // type in db: varchar(200)
	private java.util.Date updateDate; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentityName() {
		return this.identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getIdentityObverseImg() {
		return this.identityObverseImg;
	}
	public void setIdentityObverseImg(String identityObverseImg) {
		this.identityObverseImg = identityObverseImg;
	}

	public String getIdentityReverseImg() {
		return this.identityReverseImg;
	}
	public void setIdentityReverseImg(String identityReverseImg) {
		this.identityReverseImg = identityReverseImg;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return this.updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public String toString() {
		return "B2cUserIdentityCardInfo [id=" + id + ", ecUserId=" + ecUserId + ", userName=" + userName + ", identityName=" + identityName + ", identityCard=" + identityCard + ", identityObverseImg=" + identityObverseImg + ", identityReverseImg=" + identityReverseImg + ", createUserId=" + createUserId + ", createDate=" + createDate + ", updateUserId=" + updateUserId + ", updateDate=" + updateDate + "]";
	}
}
