package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcquyiMedicine implements Serializable {
	private static final long serialVersionUID = 0X72AA5F433B05B4F3L;
	private Integer id; // type in db: int(11)
	private String userId; // type in db: varchar(50)
	private String itemNo; // type in db: varchar(50)
	private String drugSpec; // type in db: varchar(50)
	private String drugName; // type in db: varchar(255)
	private String firm; // type in db: varchar(255)
	private String packageSpec; // type in db: varchar(50)
	private String quantity; // type in db: varchar(50)
	private String packageUnits; // type in db: varchar(50)
	private String dosage; // type in db: varchar(50)
	private String dosageUnits; // type in db: varchar(50)
	private String frequency; // type in db: varchar(50)
	private String frequencyCounter; // type in db: varchar(50)
	private String frequencyInterval; // type in db: varchar(50)
	private String frequencyIntervalUnit; // type in db: varchar(50)
	private String frequencyDetailDescription; // type in db: varchar(255)
	private String administration; // type in db: varchar(50)
	private String duration; // type in db: varchar(50)
	private String durationUnits; // type in db: varchar(50)
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

	public String getItemNo() {
		return this.itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDrugSpec() {
		return this.drugSpec;
	}
	public void setDrugSpec(String drugSpec) {
		this.drugSpec = drugSpec;
	}

	public String getDrugName() {
		return this.drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getFirm() {
		return this.firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getPackageSpec() {
		return this.packageSpec;
	}
	public void setPackageSpec(String packageSpec) {
		this.packageSpec = packageSpec;
	}

	public String getQuantity() {
		return this.quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPackageUnits() {
		return this.packageUnits;
	}
	public void setPackageUnits(String packageUnits) {
		this.packageUnits = packageUnits;
	}

	public String getDosage() {
		return this.dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosageUnits() {
		return this.dosageUnits;
	}
	public void setDosageUnits(String dosageUnits) {
		this.dosageUnits = dosageUnits;
	}

	public String getFrequency() {
		return this.frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFrequencyCounter() {
		return this.frequencyCounter;
	}
	public void setFrequencyCounter(String frequencyCounter) {
		this.frequencyCounter = frequencyCounter;
	}

	public String getFrequencyInterval() {
		return this.frequencyInterval;
	}
	public void setFrequencyInterval(String frequencyInterval) {
		this.frequencyInterval = frequencyInterval;
	}

	public String getFrequencyIntervalUnit() {
		return this.frequencyIntervalUnit;
	}
	public void setFrequencyIntervalUnit(String frequencyIntervalUnit) {
		this.frequencyIntervalUnit = frequencyIntervalUnit;
	}

	public String getFrequencyDetailDescription() {
		return this.frequencyDetailDescription;
	}
	public void setFrequencyDetailDescription(String frequencyDetailDescription) {
		this.frequencyDetailDescription = frequencyDetailDescription;
	}

	public String getAdministration() {
		return this.administration;
	}
	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public String getDuration() {
		return this.duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDurationUnits() {
		return this.durationUnits;
	}
	public void setDurationUnits(String durationUnits) {
		this.durationUnits = durationUnits;
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
		return "EcquyiMedicine [id=" + id + ", userId=" + userId + ", itemNo=" + itemNo + ", drugSpec=" + drugSpec + ", drugName=" + drugName + ", firm=" + firm + ", packageSpec=" + packageSpec + ", quantity=" + quantity + ", packageUnits=" + packageUnits + ", dosage=" + dosage + ", dosageUnits=" + dosageUnits + ", frequency=" + frequency + ", frequencyCounter=" + frequencyCounter + ", frequencyInterval=" + frequencyInterval + ", frequencyIntervalUnit=" + frequencyIntervalUnit + ", frequencyDetailDescription=" + frequencyDetailDescription + ", administration=" + administration + ", duration=" + duration + ", durationUnits=" + durationUnits + ", createDate=" + createDate + ", remark=" + remark + "]";
	}
}
