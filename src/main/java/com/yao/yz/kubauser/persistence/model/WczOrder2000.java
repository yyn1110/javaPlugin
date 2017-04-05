package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczOrder2000 implements Serializable {
	private static final long serialVersionUID = 0X198DE60B525E8574L;
	private String 用户名; // type in db: varchar(150)
	private String 真实姓名; // type in db: varchar(60)
	private String 手机; // type in db: varchar(60)
	private String 省; // type in db: varchar(180)
	private String 市; // type in db: varchar(180)
	private String 区; // type in db: varchar(180)
	private java.util.Date 下单时间; // type in db: timestamp

	public String get用户名() {
		return this.用户名;
	}
	public void set用户名(String 用户名) {
		this.用户名 = 用户名;
	}

	public String get真实姓名() {
		return this.真实姓名;
	}
	public void set真实姓名(String 真实姓名) {
		this.真实姓名 = 真实姓名;
	}

	public String get手机() {
		return this.手机;
	}
	public void set手机(String 手机) {
		this.手机 = 手机;
	}

	public String get省() {
		return this.省;
	}
	public void set省(String 省) {
		this.省 = 省;
	}

	public String get市() {
		return this.市;
	}
	public void set市(String 市) {
		this.市 = 市;
	}

	public String get区() {
		return this.区;
	}
	public void set区(String 区) {
		this.区 = 区;
	}

	public java.util.Date get下单时间() {
		return this.下单时间;
	}
	public void set下单时间(java.util.Date 下单时间) {
		this.下单时间 = 下单时间;
	}


	@Override
	public String toString() {
		return "WczOrder2000 [用户名=" + 用户名 + ", 真实姓名=" + 真实姓名 + ", 手机=" + 手机 + ", 省=" + 省 + ", 市=" + 市 + ", 区=" + 区 + ", 下单时间=" + 下单时间 + "]";
	}
}
