package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczOrder implements Serializable {
	private static final long serialVersionUID = 0X173B5437B0DCAEDDL;
	private String orderid; // type in db: varchar(150)
	private java.util.Date orderdate; // type in db: timestamp
	private java.math.BigDecimal theallmoney; // type in db: decimal(12,0)
	private Double productcount; // type in db: double
	private String goodsname; // type in db: varchar(150)
	private String catname; // type in db: varchar(90)
	private String username; // type in db: varchar(150)
	private String paymethodname; // type in db: varchar(150)

	public String getOrderid() {
		return this.orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public java.util.Date getOrderdate() {
		return this.orderdate;
	}
	public void setOrderdate(java.util.Date orderdate) {
		this.orderdate = orderdate;
	}

	public java.math.BigDecimal getTheallmoney() {
		return this.theallmoney;
	}
	public void setTheallmoney(java.math.BigDecimal theallmoney) {
		this.theallmoney = theallmoney;
	}

	public Double getProductcount() {
		return this.productcount;
	}
	public void setProductcount(Double productcount) {
		this.productcount = productcount;
	}

	public String getGoodsname() {
		return this.goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getCatname() {
		return this.catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymethodname() {
		return this.paymethodname;
	}
	public void setPaymethodname(String paymethodname) {
		this.paymethodname = paymethodname;
	}


	@Override
	public String toString() {
		return "WczOrder [orderid=" + orderid + ", orderdate=" + orderdate + ", theallmoney=" + theallmoney + ", productcount=" + productcount + ", goodsname=" + goodsname + ", catname=" + catname + ", username=" + username + ", paymethodname=" + paymethodname + "]";
	}
}
