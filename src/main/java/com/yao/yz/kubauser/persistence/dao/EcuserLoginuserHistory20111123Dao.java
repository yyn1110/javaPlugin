package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserLoginuserHistory20111123;

public interface EcuserLoginuserHistory20111123Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserLoginuserHistory20111123 sEcuserLoginuserHistory20111123);
	/*
	 * No primary key defined in DB table!
	 */
}
