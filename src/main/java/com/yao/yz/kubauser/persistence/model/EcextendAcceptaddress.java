package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcextendAcceptaddress implements Serializable {
	private static final long serialVersionUID = 0X8C0C9158C73D385EL;
	private Integer id; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String username; // type in db: varchar(50)
	private String realName; // type in db: varchar(50)
	private String postCode; // type in db: varchar(20)
	private String address; // type in db: varchar(200)
	private String tel; // type in db: varchar(20)
	private String mobile; // type in db: varchar(20)
	private String province; // type in db: varchar(20)
	private String city; // type in db: varchar(20)
	private String county; // type in db: varchar(20)
	private String email; // type in db: varchar(128)
	private String invoiceTitle; // type in db: varchar(100)
	private Integer showOrder; // type in db: int(11)
	private String siteId; // type in db: varchar(50)
	private String provinceName; // type in db: varchar(50)
	private String cityName; // type in db: varchar(50)
	private String countyName; // type in db: varchar(50)
	private Integer provinceNo; // type in db: int(11)
	private Integer cityNo; // type in db: int(11)
	private Integer countyNo; // type in db: int(11)
	private Integer shipAreaNo; // type in db: int(11)
	private String shipArea; // type in db: varchar(100)
	private String telCityCode; // type in db: varchar(20)
	private String telExtNumber; // type in db: varchar(20)
	private String nearByBuilding; // type in db: varchar(100)
	private Integer isDefault; // type in db: tinyint(4)
	private String quickOrderName; // type in db: varchar(50)
	private String deliverType; // type in db: varchar(50)
	private String payBankName; // type in db: varchar(50)
	private Integer invoiceType; // type in db: smallint(2)
	private Integer payType; // type in db: int(11)
	private String invoiceInfo; // type in db: varchar(2000)
	private Integer addressType; // type in db: int(11)
	private Integer isDefaultOfQuickOrderInfo; // type in db: int(11)
	private Integer isLastAddress; // type in db: bigint(2)
	private java.util.Date lastUseTime; // type in db: timestamp
	private String payBankCode; // type in db: varchar(10)
	private String payBankUrl; // type in db: varchar(100)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return this.realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPostCode() {
		return this.postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}
	public void setCounty(String county) {
		this.county = county;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Integer getShowOrder() {
		return this.showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getSiteId() {
		return this.siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return this.countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Integer getProvinceNo() {
		return this.provinceNo;
	}
	public void setProvinceNo(Integer provinceNo) {
		this.provinceNo = provinceNo;
	}

	public Integer getCityNo() {
		return this.cityNo;
	}
	public void setCityNo(Integer cityNo) {
		this.cityNo = cityNo;
	}

	public Integer getCountyNo() {
		return this.countyNo;
	}
	public void setCountyNo(Integer countyNo) {
		this.countyNo = countyNo;
	}

	public Integer getShipAreaNo() {
		return this.shipAreaNo;
	}
	public void setShipAreaNo(Integer shipAreaNo) {
		this.shipAreaNo = shipAreaNo;
	}

	public String getShipArea() {
		return this.shipArea;
	}
	public void setShipArea(String shipArea) {
		this.shipArea = shipArea;
	}

	public String getTelCityCode() {
		return this.telCityCode;
	}
	public void setTelCityCode(String telCityCode) {
		this.telCityCode = telCityCode;
	}

	public String getTelExtNumber() {
		return this.telExtNumber;
	}
	public void setTelExtNumber(String telExtNumber) {
		this.telExtNumber = telExtNumber;
	}

	public String getNearByBuilding() {
		return this.nearByBuilding;
	}
	public void setNearByBuilding(String nearByBuilding) {
		this.nearByBuilding = nearByBuilding;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getQuickOrderName() {
		return this.quickOrderName;
	}
	public void setQuickOrderName(String quickOrderName) {
		this.quickOrderName = quickOrderName;
	}

	public String getDeliverType() {
		return this.deliverType;
	}
	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}

	public String getPayBankName() {
		return this.payBankName;
	}
	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}

	public Integer getInvoiceType() {
		return this.invoiceType;
	}
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Integer getPayType() {
		return this.payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getInvoiceInfo() {
		return this.invoiceInfo;
	}
	public void setInvoiceInfo(String invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public Integer getAddressType() {
		return this.addressType;
	}
	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	public Integer getIsDefaultOfQuickOrderInfo() {
		return this.isDefaultOfQuickOrderInfo;
	}
	public void setIsDefaultOfQuickOrderInfo(Integer isDefaultOfQuickOrderInfo) {
		this.isDefaultOfQuickOrderInfo = isDefaultOfQuickOrderInfo;
	}

	public Integer getIsLastAddress() {
		return this.isLastAddress;
	}
	public void setIsLastAddress(Integer isLastAddress) {
		this.isLastAddress = isLastAddress;
	}

	public java.util.Date getLastUseTime() {
		return this.lastUseTime;
	}
	public void setLastUseTime(java.util.Date lastUseTime) {
		this.lastUseTime = lastUseTime;
	}

	public String getPayBankCode() {
		return this.payBankCode;
	}
	public void setPayBankCode(String payBankCode) {
		this.payBankCode = payBankCode;
	}

	public String getPayBankUrl() {
		return this.payBankUrl;
	}
	public void setPayBankUrl(String payBankUrl) {
		this.payBankUrl = payBankUrl;
	}


	@Override
	public String toString() {
		return "EcextendAcceptaddress [id=" + id + ", userId=" + userId + ", username=" + username + ", realName=" + realName + ", postCode=" + postCode + ", address=" + address + ", tel=" + tel + ", mobile=" + mobile + ", province=" + province + ", city=" + city + ", county=" + county + ", email=" + email + ", invoiceTitle=" + invoiceTitle + ", showOrder=" + showOrder + ", siteId=" + siteId + ", provinceName=" + provinceName + ", cityName=" + cityName + ", countyName=" + countyName + ", provinceNo=" + provinceNo + ", cityNo=" + cityNo + ", countyNo=" + countyNo + ", shipAreaNo=" + shipAreaNo + ", shipArea=" + shipArea + ", telCityCode=" + telCityCode + ", telExtNumber=" + telExtNumber + ", nearByBuilding=" + nearByBuilding + ", isDefault=" + isDefault + ", quickOrderName=" + quickOrderName + ", deliverType=" + deliverType + ", payBankName=" + payBankName + ", invoiceType=" + invoiceType + ", payType=" + payType + ", invoiceInfo=" + invoiceInfo + ", addressType=" + addressType + ", isDefaultOfQuickOrderInfo=" + isDefaultOfQuickOrderInfo + ", isLastAddress=" + isLastAddress + ", lastUseTime=" + lastUseTime + ", payBankCode=" + payBankCode + ", payBankUrl=" + payBankUrl + "]";
	}
}
