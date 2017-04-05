package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.XyyTempUser;

public interface XyyTempUserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(XyyTempUser sXyyTempUser);
	/*
	 * No primary key defined in DB table!
	 */
}
