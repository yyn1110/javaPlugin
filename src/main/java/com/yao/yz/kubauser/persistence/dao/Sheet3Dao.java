package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Sheet3;

public interface Sheet3Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Sheet3 sSheet3);
	/*
	 * No primary key defined in DB table!
	 */
}
