package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcquyiShipto implements Serializable {
	private static final long serialVersionUID = 0XA7CE9441F85BFB61L;
	private Integer id; // type in db: int(11)
	private String userId; // type in db: varchar(50)
	private String person; // type in db: varchar(50)
	private String contact; // type in db: varchar(50)
	private String provinceName; // type in db: varchar(50)
	private String provinceCode; // type in db: varchar(50)
	private String cityName; // type in db: varchar(50)
	private String cityCode; // type in db: varchar(50)
	private String districtName; // type in db: varchar(50)
	private String districtCode; // type in db: varchar(50)
	private String detailAddress; // type in db: varchar(255)
	private String fullAddress; // type in db: varchar(255)
	private java.util.Date createDate; // type in db: datetime
	private String remark; // type in db: varchar(50)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPerson() {
		return this.person;
	}
	public void setPerson(String person) {
		this.person = person;
	}

	public String getContact() {
		return this.contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getProvinceName() {
		return this.provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return this.cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDetailAddress() {
		return this.detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "EcquyiShipto [id=" + id + ", userId=" + userId + ", person=" + person + ", contact=" + contact + ", provinceName=" + provinceName + ", provinceCode=" + provinceCode + ", cityName=" + cityName + ", cityCode=" + cityCode + ", districtName=" + districtName + ", districtCode=" + districtCode + ", detailAddress=" + detailAddress + ", fullAddress=" + fullAddress + ", createDate=" + createDate + ", remark=" + remark + "]";
	}
}
