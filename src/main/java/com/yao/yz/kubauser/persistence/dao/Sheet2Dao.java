package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Sheet2;

public interface Sheet2Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Sheet2 sSheet2);
	/*
	 * No primary key defined in DB table!
	 */
}
