package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcquyiPatient implements Serializable {
	private static final long serialVersionUID = 0XFDE229F0F9FCF35DL;
	private Integer id; // type in db: int(11)
	private String userId; // type in db: varchar(50)
	private String registerId; // type in db: varchar(50)
	private String hospitalId; // type in db: varchar(50)
	private String hospitalName; // type in db: varchar(255)
	private String doctorId; // type in db: varchar(50)
	private String prescriptionNo; // type in db: varchar(255)
	private java.util.Date prescriptionDate; // type in db: datetime
	private String departmentName; // type in db: varchar(255)
	private String patientId; // type in db: varchar(50)
	private String patientName; // type in db: varchar(50)
	private String gender; // type in db: varchar(5)
	private Integer age; // type in db: int(11)
	private String phoneNumber; // type in db: varchar(20)
	private String address; // type in db: varchar(255)
	private String diagnosis; // type in db: varchar(255)
	private Integer prescriptionType; // type in db: int(11)
	private Integer prescriptionSource; // type in db: int(11)
	private String comment; // type in db: varchar(255)
	private Integer status; // type in db: int(11)
	private String cardNo; // type in db: varchar(50)
	private String verify; // type in db: varchar(50)
	private String checks; // type in db: varchar(50)
	private String deploy; // type in db: varchar(50)
	private String assign; // type in db: varchar(50)
	private java.util.Date createDate; // type in db: datetime

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

	public String getRegisterId() {
		return this.registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getHospitalId() {
		return this.hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorId() {
		return this.doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPrescriptionNo() {
		return this.prescriptionNo;
	}
	public void setPrescriptionNo(String prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}

	public java.util.Date getPrescriptionDate() {
		return this.prescriptionDate;
	}
	public void setPrescriptionDate(java.util.Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPatientId() {
		return this.patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return this.patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return this.age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Integer getPrescriptionType() {
		return this.prescriptionType;
	}
	public void setPrescriptionType(Integer prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

	public Integer getPrescriptionSource() {
		return this.prescriptionSource;
	}
	public void setPrescriptionSource(Integer prescriptionSource) {
		this.prescriptionSource = prescriptionSource;
	}

	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getVerify() {
		return this.verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getChecks() {
		return this.checks;
	}
	public void setChecks(String checks) {
		this.checks = checks;
	}

	public String getDeploy() {
		return this.deploy;
	}
	public void setDeploy(String deploy) {
		this.deploy = deploy;
	}

	public String getAssign() {
		return this.assign;
	}
	public void setAssign(String assign) {
		this.assign = assign;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "EcquyiPatient [id=" + id + ", userId=" + userId + ", registerId=" + registerId + ", hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", doctorId=" + doctorId + ", prescriptionNo=" + prescriptionNo + ", prescriptionDate=" + prescriptionDate + ", departmentName=" + departmentName + ", patientId=" + patientId + ", patientName=" + patientName + ", gender=" + gender + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + ", diagnosis=" + diagnosis + ", prescriptionType=" + prescriptionType + ", prescriptionSource=" + prescriptionSource + ", comment=" + comment + ", status=" + status + ", cardNo=" + cardNo + ", verify=" + verify + ", checks=" + checks + ", deploy=" + deploy + ", assign=" + assign + ", createDate=" + createDate + "]";
	}
}
