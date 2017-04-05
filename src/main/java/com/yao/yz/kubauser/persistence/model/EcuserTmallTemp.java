package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserTmallTemp implements Serializable {
	private static final long serialVersionUID = 0X6CC0F94FFA707E96L;
	private Integer ecuserid; // type in db: int(11)

	public Integer getEcuserid() {
		return this.ecuserid;
	}
	public void setEcuserid(Integer ecuserid) {
		this.ecuserid = ecuserid;
	}


	@Override
	public String toString() {
		return "EcuserTmallTemp [ecuserid=" + ecuserid + "]";
	}
}
