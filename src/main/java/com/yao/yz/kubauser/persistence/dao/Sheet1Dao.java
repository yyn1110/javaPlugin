package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Sheet1;

public interface Sheet1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Sheet1 sSheet1);
	/*
	 * No primary key defined in DB table!
	 */
}
