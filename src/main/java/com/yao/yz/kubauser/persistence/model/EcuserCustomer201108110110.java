package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomer201108110110 implements Serializable {
	private static final long serialVersionUID = 0X80BC29317F5F78B6L;
	private Integer ecUserId; // type in db: int(11)
	private Integer ecUId; // type in db: int(11)
	private String loginEmail; // type in db: varchar(250)
	private String loginMobile; // type in db: varchar(20)
	private String id; // type in db: varchar(50)
	private Integer status; // type in db: int(11)
	private java.util.Date createDate; // type in db: datetime
	private java.util.Date modifyDate; // type in db: datetime
	private String name; // type in db: varchar(100)
	private Integer gender; // type in db: int(11)
	private String cellphone; // type in db: varchar(50)
	private String telephone; // type in db: varchar(50)
	private String otherTel; // type in db: varchar(50)
	private String fax; // type in db: varchar(50)
	private String msn; // type in db: varchar(50)
	private String qq; // type in db: varchar(50)
	private String aliww; // type in db: varchar(50)
	private String otherIm; // type in db: varchar(50)
	private String email; // type in db: varchar(50)
	private String memo; // type in db: varchar(255)
	private String state; // type in db: varchar(25)
	private String city; // type in db: varchar(25)
	private String district; // type in db: varchar(25)
	private String postcode; // type in db: varchar(10)
	private String address; // type in db: varchar(255)
	private Integer income; // type in db: int(11)
	private Integer isDeleted; // type in db: int(11)
	private String userId; // type in db: varchar(50)
	private Integer source; // type in db: int(11)
	private String password; // type in db: varchar(50)
	private String salt; // type in db: varchar(24)
	private Integer userscore; // type in db: int(11)
	private Integer enterCount; // type in db: int(11)
	private java.util.Date lastLoginTime; // type in db: datetime
	private String registerIP; // type in db: varchar(50)
	private String ipaddress; // type in db: varchar(50)
	private Integer type; // type in db: int(11)
	private String websiteSource; // type in db: varchar(50)
	private Integer tuanflags; // type in db: tinyint(4)
	private Integer userLevelId; // type in db: int(11)
	private java.util.Date userLevelStartTime; // type in db: datetime
	private java.util.Date userLevelEndTime; // type in db: datetime
	private java.util.Date birthDay; // type in db: datetime
	private String nickName; // type in db: varchar(50)
	private String imgUrl; // type in db: varchar(255)
	private java.math.BigDecimal yearOrderFee; // type in db: decimal(10,2)
	private java.math.BigDecimal totalFinishOrderFee; // type in db: decimal(18,2)
	private Integer totalFinishOrderCount; // type in db: int(11)
	private java.math.BigDecimal userLevelValidOrderFee; // type in db: decimal(10,2)
	private Integer userLevelValidBuyCount; // type in db: int(11)
	private java.util.Date userLevelLastModifyTime; // type in db: datetime
	private Integer userLevelIsHandProtect; // type in db: tinyint(4)
	private Integer partnerType; // type in db: int(11)

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}

	public Integer getEcUId() {
		return this.ecUId;
	}
	public void setEcUId(Integer ecUId) {
		this.ecUId = ecUId;
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginMobile() {
		return this.loginMobile;
	}
	public void setLoginMobile(String loginMobile) {
		this.loginMobile = loginMobile;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getModifyDate() {
		return this.modifyDate;
	}
	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getCellphone() {
		return this.cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOtherTel() {
		return this.otherTel;
	}
	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}

	public String getFax() {
		return this.fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMsn() {
		return this.msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return this.qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAliww() {
		return this.aliww;
	}
	public void setAliww(String aliww) {
		this.aliww = aliww;
	}

	public String getOtherIm() {
		return this.otherIm;
	}
	public void setOtherIm(String otherIm) {
		this.otherIm = otherIm;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostcode() {
		return this.postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIncome() {
		return this.income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getIsDeleted() {
		return this.isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSource() {
		return this.source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getUserscore() {
		return this.userscore;
	}
	public void setUserscore(Integer userscore) {
		this.userscore = userscore;
	}

	public Integer getEnterCount() {
		return this.enterCount;
	}
	public void setEnterCount(Integer enterCount) {
		this.enterCount = enterCount;
	}

	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRegisterIP() {
		return this.registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getWebsiteSource() {
		return this.websiteSource;
	}
	public void setWebsiteSource(String websiteSource) {
		this.websiteSource = websiteSource;
	}

	public Integer getTuanflags() {
		return this.tuanflags;
	}
	public void setTuanflags(Integer tuanflags) {
		this.tuanflags = tuanflags;
	}

	public Integer getUserLevelId() {
		return this.userLevelId;
	}
	public void setUserLevelId(Integer userLevelId) {
		this.userLevelId = userLevelId;
	}

	public java.util.Date getUserLevelStartTime() {
		return this.userLevelStartTime;
	}
	public void setUserLevelStartTime(java.util.Date userLevelStartTime) {
		this.userLevelStartTime = userLevelStartTime;
	}

	public java.util.Date getUserLevelEndTime() {
		return this.userLevelEndTime;
	}
	public void setUserLevelEndTime(java.util.Date userLevelEndTime) {
		this.userLevelEndTime = userLevelEndTime;
	}

	public java.util.Date getBirthDay() {
		return this.birthDay;
	}
	public void setBirthDay(java.util.Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public java.math.BigDecimal getYearOrderFee() {
		return this.yearOrderFee;
	}
	public void setYearOrderFee(java.math.BigDecimal yearOrderFee) {
		this.yearOrderFee = yearOrderFee;
	}

	public java.math.BigDecimal getTotalFinishOrderFee() {
		return this.totalFinishOrderFee;
	}
	public void setTotalFinishOrderFee(java.math.BigDecimal totalFinishOrderFee) {
		this.totalFinishOrderFee = totalFinishOrderFee;
	}

	public Integer getTotalFinishOrderCount() {
		return this.totalFinishOrderCount;
	}
	public void setTotalFinishOrderCount(Integer totalFinishOrderCount) {
		this.totalFinishOrderCount = totalFinishOrderCount;
	}

	public java.math.BigDecimal getUserLevelValidOrderFee() {
		return this.userLevelValidOrderFee;
	}
	public void setUserLevelValidOrderFee(java.math.BigDecimal userLevelValidOrderFee) {
		this.userLevelValidOrderFee = userLevelValidOrderFee;
	}

	public Integer getUserLevelValidBuyCount() {
		return this.userLevelValidBuyCount;
	}
	public void setUserLevelValidBuyCount(Integer userLevelValidBuyCount) {
		this.userLevelValidBuyCount = userLevelValidBuyCount;
	}

	public java.util.Date getUserLevelLastModifyTime() {
		return this.userLevelLastModifyTime;
	}
	public void setUserLevelLastModifyTime(java.util.Date userLevelLastModifyTime) {
		this.userLevelLastModifyTime = userLevelLastModifyTime;
	}

	public Integer getUserLevelIsHandProtect() {
		return this.userLevelIsHandProtect;
	}
	public void setUserLevelIsHandProtect(Integer userLevelIsHandProtect) {
		this.userLevelIsHandProtect = userLevelIsHandProtect;
	}

	public Integer getPartnerType() {
		return this.partnerType;
	}
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}


	@Override
	public String toString() {
		return "EcuserCustomer201108110110 [ecUserId=" + ecUserId + ", ecUId=" + ecUId + ", loginEmail=" + loginEmail + ", loginMobile=" + loginMobile + ", id=" + id + ", status=" + status + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", name=" + name + ", gender=" + gender + ", cellphone=" + cellphone + ", telephone=" + telephone + ", otherTel=" + otherTel + ", fax=" + fax + ", msn=" + msn + ", qq=" + qq + ", aliww=" + aliww + ", otherIm=" + otherIm + ", email=" + email + ", memo=" + memo + ", state=" + state + ", city=" + city + ", district=" + district + ", postcode=" + postcode + ", address=" + address + ", income=" + income + ", isDeleted=" + isDeleted + ", userId=" + userId + ", source=" + source + ", password=" + password + ", salt=" + salt + ", userscore=" + userscore + ", enterCount=" + enterCount + ", lastLoginTime=" + lastLoginTime + ", registerIP=" + registerIP + ", ipaddress=" + ipaddress + ", type=" + type + ", websiteSource=" + websiteSource + ", tuanflags=" + tuanflags + ", userLevelId=" + userLevelId + ", userLevelStartTime=" + userLevelStartTime + ", userLevelEndTime=" + userLevelEndTime + ", birthDay=" + birthDay + ", nickName=" + nickName + ", imgUrl=" + imgUrl + ", yearOrderFee=" + yearOrderFee + ", totalFinishOrderFee=" + totalFinishOrderFee + ", totalFinishOrderCount=" + totalFinishOrderCount + ", userLevelValidOrderFee=" + userLevelValidOrderFee + ", userLevelValidBuyCount=" + userLevelValidBuyCount + ", userLevelLastModifyTime=" + userLevelLastModifyTime + ", userLevelIsHandProtect=" + userLevelIsHandProtect + ", partnerType=" + partnerType + "]";
	}
}
