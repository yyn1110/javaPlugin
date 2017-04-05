package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserChangeprivilege implements Serializable {
	private static final long serialVersionUID = 0X1C524BB225EE844EL;
	private Integer id; // type in db: int(8)
	private String userName; // type in db: varchar(100)
	private Integer price; // type in db: int(4)
	private Integer count; // type in db: int(4)
	private Integer successCount; // type in db: int(11)

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

	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSuccessCount() {
		return this.successCount;
	}
	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}


	@Override
	public String toString() {
		return "EcuserChangeprivilege [id=" + id + ", userName=" + userName + ", price=" + price + ", count=" + count + ", successCount=" + successCount + "]";
	}
}
