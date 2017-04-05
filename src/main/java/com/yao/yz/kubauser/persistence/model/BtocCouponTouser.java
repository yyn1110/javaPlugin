package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class BtocCouponTouser implements Serializable {
	private static final long serialVersionUID = 0X10E5B229FBB5E803L;
	private Integer id; // type in db: int(11)
	private Integer couponid; // type in db: int(11)
	private Integer batchid; // type in db: int(11)
	private String batchcode; // type in db: varchar(20)
	private String code; // type in db: varchar(50)
	private String activecode; // type in db: varchar(20)
	private String username; // type in db: varchar(50)
	private Double denomination; // type in db: double(50,2)
	private Integer costdeptid; // type in db: int(11)
	private Double limitprice; // type in db: double(50,2)
	private Integer status; // type in db: int(2)
	private Integer sendtype; // type in db: int(2)
	private String sendorderno; // type in db: varchar(20)
	private java.util.Date begindate; // type in db: timestamp
	private java.util.Date enddate; // type in db: timestamp
	private java.util.Date senddate; // type in db: timestamp
	private java.util.Date activadate; // type in db: timestamp
	private String useorderno; // type in db: varchar(20)
	private java.util.Date usedate; // type in db: timestamp
	private Integer isautorefund; // type in db: int(2)
	private java.util.Date refunddate; // type in db: timestamp
	private String refundorderno; // type in db: varchar(20)
	private Integer ismainrefund; // type in db: int(2)
	private Integer issplitrefund; // type in db: int(2)
	private Integer splitisrefund; // type in db: int(2)
	private java.util.Date splitrefunddate; // type in db: timestamp
	private String erpsplitorderid; // type in db: varchar(50)
	private Double splitredeemprice; // type in db: double(50,2)
	private Integer redeemstatus; // type in db: int(2)
	private String splitnewnumber; // type in db: varchar(50)
	private String redeemlog; // type in db: varchar(500)
	private Integer islimituse; // type in db: int(2)
	private String islimituseinfo; // type in db: text
	private Integer effectivedays; // type in db: int(10)
	private Integer effectivetype; // type in db: int(2)
	private String remark; // type in db: varchar(500)
	private String logs; // type in db: varchar(500)
	private Integer isexpire; // type in db: int(2)
	private java.util.Date currentTime; // type in db: timestamp
	private String itemid; // type in db: varchar(12)
	private Integer isespecitem; // type in db: int(2)
	private String uselimitsay; // type in db: varchar(500)
	private Integer jediscode; // type in db: bigint(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCouponid() {
		return this.couponid;
	}
	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	public Integer getBatchid() {
		return this.batchid;
	}
	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}

	public String getBatchcode() {
		return this.batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getActivecode() {
		return this.activecode;
	}
	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Double getDenomination() {
		return this.denomination;
	}
	public void setDenomination(Double denomination) {
		this.denomination = denomination;
	}

	public Integer getCostdeptid() {
		return this.costdeptid;
	}
	public void setCostdeptid(Integer costdeptid) {
		this.costdeptid = costdeptid;
	}

	public Double getLimitprice() {
		return this.limitprice;
	}
	public void setLimitprice(Double limitprice) {
		this.limitprice = limitprice;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSendtype() {
		return this.sendtype;
	}
	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}

	public String getSendorderno() {
		return this.sendorderno;
	}
	public void setSendorderno(String sendorderno) {
		this.sendorderno = sendorderno;
	}

	public java.util.Date getBegindate() {
		return this.begindate;
	}
	public void setBegindate(java.util.Date begindate) {
		this.begindate = begindate;
	}

	public java.util.Date getEnddate() {
		return this.enddate;
	}
	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}

	public java.util.Date getSenddate() {
		return this.senddate;
	}
	public void setSenddate(java.util.Date senddate) {
		this.senddate = senddate;
	}

	public java.util.Date getActivadate() {
		return this.activadate;
	}
	public void setActivadate(java.util.Date activadate) {
		this.activadate = activadate;
	}

	public String getUseorderno() {
		return this.useorderno;
	}
	public void setUseorderno(String useorderno) {
		this.useorderno = useorderno;
	}

	public java.util.Date getUsedate() {
		return this.usedate;
	}
	public void setUsedate(java.util.Date usedate) {
		this.usedate = usedate;
	}

	public Integer getIsautorefund() {
		return this.isautorefund;
	}
	public void setIsautorefund(Integer isautorefund) {
		this.isautorefund = isautorefund;
	}

	public java.util.Date getRefunddate() {
		return this.refunddate;
	}
	public void setRefunddate(java.util.Date refunddate) {
		this.refunddate = refunddate;
	}

	public String getRefundorderno() {
		return this.refundorderno;
	}
	public void setRefundorderno(String refundorderno) {
		this.refundorderno = refundorderno;
	}

	public Integer getIsmainrefund() {
		return this.ismainrefund;
	}
	public void setIsmainrefund(Integer ismainrefund) {
		this.ismainrefund = ismainrefund;
	}

	public Integer getIssplitrefund() {
		return this.issplitrefund;
	}
	public void setIssplitrefund(Integer issplitrefund) {
		this.issplitrefund = issplitrefund;
	}

	public Integer getSplitisrefund() {
		return this.splitisrefund;
	}
	public void setSplitisrefund(Integer splitisrefund) {
		this.splitisrefund = splitisrefund;
	}

	public java.util.Date getSplitrefunddate() {
		return this.splitrefunddate;
	}
	public void setSplitrefunddate(java.util.Date splitrefunddate) {
		this.splitrefunddate = splitrefunddate;
	}

	public String getErpsplitorderid() {
		return this.erpsplitorderid;
	}
	public void setErpsplitorderid(String erpsplitorderid) {
		this.erpsplitorderid = erpsplitorderid;
	}

	public Double getSplitredeemprice() {
		return this.splitredeemprice;
	}
	public void setSplitredeemprice(Double splitredeemprice) {
		this.splitredeemprice = splitredeemprice;
	}

	public Integer getRedeemstatus() {
		return this.redeemstatus;
	}
	public void setRedeemstatus(Integer redeemstatus) {
		this.redeemstatus = redeemstatus;
	}

	public String getSplitnewnumber() {
		return this.splitnewnumber;
	}
	public void setSplitnewnumber(String splitnewnumber) {
		this.splitnewnumber = splitnewnumber;
	}

	public String getRedeemlog() {
		return this.redeemlog;
	}
	public void setRedeemlog(String redeemlog) {
		this.redeemlog = redeemlog;
	}

	public Integer getIslimituse() {
		return this.islimituse;
	}
	public void setIslimituse(Integer islimituse) {
		this.islimituse = islimituse;
	}

	public String getIslimituseinfo() {
		return this.islimituseinfo;
	}
	public void setIslimituseinfo(String islimituseinfo) {
		this.islimituseinfo = islimituseinfo;
	}

	public Integer getEffectivedays() {
		return this.effectivedays;
	}
	public void setEffectivedays(Integer effectivedays) {
		this.effectivedays = effectivedays;
	}

	public Integer getEffectivetype() {
		return this.effectivetype;
	}
	public void setEffectivetype(Integer effectivetype) {
		this.effectivetype = effectivetype;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLogs() {
		return this.logs;
	}
	public void setLogs(String logs) {
		this.logs = logs;
	}

	public Integer getIsexpire() {
		return this.isexpire;
	}
	public void setIsexpire(Integer isexpire) {
		this.isexpire = isexpire;
	}

	public java.util.Date getCurrentTime() {
		return this.currentTime;
	}
	public void setCurrentTime(java.util.Date currentTime) {
		this.currentTime = currentTime;
	}

	public String getItemid() {
		return this.itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Integer getIsespecitem() {
		return this.isespecitem;
	}
	public void setIsespecitem(Integer isespecitem) {
		this.isespecitem = isespecitem;
	}

	public String getUselimitsay() {
		return this.uselimitsay;
	}
	public void setUselimitsay(String uselimitsay) {
		this.uselimitsay = uselimitsay;
	}

	public Integer getJediscode() {
		return this.jediscode;
	}
	public void setJediscode(Integer jediscode) {
		this.jediscode = jediscode;
	}


	@Override
	public String toString() {
		return "BtocCouponTouser [id=" + id + ", couponid=" + couponid + ", batchid=" + batchid + ", batchcode=" + batchcode + ", code=" + code + ", activecode=" + activecode + ", username=" + username + ", denomination=" + denomination + ", costdeptid=" + costdeptid + ", limitprice=" + limitprice + ", status=" + status + ", sendtype=" + sendtype + ", sendorderno=" + sendorderno + ", begindate=" + begindate + ", enddate=" + enddate + ", senddate=" + senddate + ", activadate=" + activadate + ", useorderno=" + useorderno + ", usedate=" + usedate + ", isautorefund=" + isautorefund + ", refunddate=" + refunddate + ", refundorderno=" + refundorderno + ", ismainrefund=" + ismainrefund + ", issplitrefund=" + issplitrefund + ", splitisrefund=" + splitisrefund + ", splitrefunddate=" + splitrefunddate + ", erpsplitorderid=" + erpsplitorderid + ", splitredeemprice=" + splitredeemprice + ", redeemstatus=" + redeemstatus + ", splitnewnumber=" + splitnewnumber + ", redeemlog=" + redeemlog + ", islimituse=" + islimituse + ", islimituseinfo=" + islimituseinfo + ", effectivedays=" + effectivedays + ", effectivetype=" + effectivetype + ", remark=" + remark + ", logs=" + logs + ", isexpire=" + isexpire + ", currentTime=" + currentTime + ", itemid=" + itemid + ", isespecitem=" + isespecitem + ", uselimitsay=" + uselimitsay + ", jediscode=" + jediscode + "]";
	}
}
