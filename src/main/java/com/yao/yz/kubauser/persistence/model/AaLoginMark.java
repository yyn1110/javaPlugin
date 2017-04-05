package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class AaLoginMark implements Serializable {
	private static final long serialVersionUID = 0X2332607CBB7A6653L;
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
		return "AaLoginMark [userid=" + userid + ", web=" + web + ", app=" + app + "]";
	}
}
