package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczUserlevescore implements Serializable {
	private static final long serialVersionUID = 0XCF8438038BFE997CL;
	private String id; // type in db: varchar(50)
	private Integer userlevelid; // type in db: int(11)
	private Integer userscore; // type in db: int(11)

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserlevelid() {
		return this.userlevelid;
	}
	public void setUserlevelid(Integer userlevelid) {
		this.userlevelid = userlevelid;
	}

	public Integer getUserscore() {
		return this.userscore;
	}
	public void setUserscore(Integer userscore) {
		this.userscore = userscore;
	}


	@Override
	public String toString() {
		return "WczUserlevescore [id=" + id + ", userlevelid=" + userlevelid + ", userscore=" + userscore + "]";
	}
}
