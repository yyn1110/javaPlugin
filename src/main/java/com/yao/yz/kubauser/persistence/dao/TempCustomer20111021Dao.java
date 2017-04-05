package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCustomer20111021;

public interface TempCustomer20111021Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCustomer20111021 sTempCustomer20111021);
	/*
	 * No primary key defined in DB table!
	 */
}
