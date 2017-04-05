package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Lotteryuserinfo implements Serializable {
	private static final long serialVersionUID = 0X9C366207AC59DBF0L;
	private String userName; // type in db: varchar(50)
	private String tel; // type in db: varchar(20)
	private Integer userId; // type in db: int(11)
	private Integer id; // type in db: int(11)
	private String address; // type in db: varchar(500)
	private String remark; // type in db: varchar(200)
	private Integer actType; // type in db: int(11)
	private String ip; // type in db: varchar(20)
	private String goodsName; // type in db: varchar(50)
	private Integer goodsId; // type in db: int(11)
	private String realName; // type in db: varchar(50)

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getActType() {
		return this.actType;
	}
	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGoodsName() {
		return this.goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getRealName() {
		return this.realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}


	@Override
	public String toString() {
		return "Lotteryuserinfo [userName=" + userName + ", tel=" + tel + ", userId=" + userId + ", id=" + id + ", address=" + address + ", remark=" + remark + ", actType=" + actType + ", ip=" + ip + ", goodsName=" + goodsName + ", goodsId=" + goodsId + ", realName=" + realName + "]";
	}
}
