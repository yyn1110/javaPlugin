package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCooperationuserBaidu2011101117 implements Serializable {
	private static final long serialVersionUID = 0X9F4096B729B2EC08L;
	private Integer ecuserid; // type in db: int(11)
	private String id; // type in db: varchar(50)
	private Integer partnerType; // type in db: int(11)

	public Integer getEcuserid() {
		return this.ecuserid;
	}
	public void setEcuserid(Integer ecuserid) {
		this.ecuserid = ecuserid;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getPartnerType() {
		return this.partnerType;
	}
	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}


	@Override
	public String toString() {
		return "EcuserCooperationuserBaidu2011101117 [ecuserid=" + ecuserid + ", id=" + id + ", partnerType=" + partnerType + "]";
	}
}
