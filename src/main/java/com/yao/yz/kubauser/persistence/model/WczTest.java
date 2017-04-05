package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczTest implements Serializable {
	private static final long serialVersionUID = 0XC5DC089A53A5BFA7L;
	private String orderid; // type in db: varchar(60)
	private String username; // type in db: varchar(60)
	private java.util.Date orderdate; // type in db: datetime
	private java.util.Date orderfinishtime; // type in db: datetime
	private java.math.BigDecimal theallmoney; // type in db: decimal(10,2)
	private String catname; // type in db: varchar(60)
	private String goodsname; // type in db: varchar(300)
	private Integer productscore; // type in db: int(11)
	private Integer orderScore; // type in db: int(11)

	public String getOrderid() {
		return this.orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public java.util.Date getOrderdate() {
		return this.orderdate;
	}
	public void setOrderdate(java.util.Date orderdate) {
		this.orderdate = orderdate;
	}

	public java.util.Date getOrderfinishtime() {
		return this.orderfinishtime;
	}
	public void setOrderfinishtime(java.util.Date orderfinishtime) {
		this.orderfinishtime = orderfinishtime;
	}

	public java.math.BigDecimal getTheallmoney() {
		return this.theallmoney;
	}
	public void setTheallmoney(java.math.BigDecimal theallmoney) {
		this.theallmoney = theallmoney;
	}

	public String getCatname() {
		return this.catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getGoodsname() {
		return this.goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getProductscore() {
		return this.productscore;
	}
	public void setProductscore(Integer productscore) {
		this.productscore = productscore;
	}

	public Integer getOrderScore() {
		return this.orderScore;
	}
	public void setOrderScore(Integer orderScore) {
		this.orderScore = orderScore;
	}


	@Override
	public String toString() {
		return "WczTest [orderid=" + orderid + ", username=" + username + ", orderdate=" + orderdate + ", orderfinishtime=" + orderfinishtime + ", theallmoney=" + theallmoney + ", catname=" + catname + ", goodsname=" + goodsname + ", productscore=" + productscore + ", orderScore=" + orderScore + "]";
	}
}
