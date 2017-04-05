package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class LotteryuserBak201109281618 implements Serializable {
	private static final long serialVersionUID = 0X76D58C7A98F14084L;
	private Integer id; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private Integer userId; // type in db: int(11)
	private String goodsName; // type in db: varchar(100)
	private String goodsId; // type in db: varchar(20)
	private java.util.Date lotteryTime; // type in db: datetime
	private String ip; // type in db: varchar(20)
	private Integer actType; // type in db: int(11)
	private java.util.Date lotteryDate; // type in db: date

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsId() {
		return this.goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public java.util.Date getLotteryTime() {
		return this.lotteryTime;
	}
	public void setLotteryTime(java.util.Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getActType() {
		return this.actType;
	}
	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public java.util.Date getLotteryDate() {
		return this.lotteryDate;
	}
	public void setLotteryDate(java.util.Date lotteryDate) {
		this.lotteryDate = lotteryDate;
	}


	@Override
	public String toString() {
		return "LotteryuserBak201109281618 [id=" + id + ", userName=" + userName + ", userId=" + userId + ", goodsName=" + goodsName + ", goodsId=" + goodsId + ", lotteryTime=" + lotteryTime + ", ip=" + ip + ", actType=" + actType + ", lotteryDate=" + lotteryDate + "]";
	}
}
