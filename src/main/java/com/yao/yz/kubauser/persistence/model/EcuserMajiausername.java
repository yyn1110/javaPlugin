package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserMajiausername implements Serializable {
	private static final long serialVersionUID = 0X575AA159C8CE9CA0L;
	private Integer id; // type in db: int(11)
	private String majianame; // type in db: varchar(50)
	private Integer type; // type in db: int(11)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getMajianame() {
		return this.majianame;
	}
	public void setMajianame(String majianame) {
		this.majianame = majianame;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "EcuserMajiausername [id=" + id + ", majianame=" + majianame + ", type=" + type + "]";
	}
}
