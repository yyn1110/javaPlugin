package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class AaUseMark implements Serializable {
	private static final long serialVersionUID = 0XEA6BC8AB1479F2D3L;
	private Integer userid; // type in db: int(11)
	private Integer web; // type in db: int(11)
	private Integer app; // type in db: int(11)

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getWeb() {
		return this.web;
	}
	public void setWeb(Integer web) {
		this.web = web;
	}

	public Integer getApp() {
		return this.app;
	}
	public void setApp(Integer app) {
		this.app = app;
	}


	@Override
	public String toString() {
		return "AaUseMark [userid=" + userid + ", web=" + web + ", app=" + app + "]";
	}
}
