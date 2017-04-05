package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempBadip;

public interface TempBadipDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempBadip sTempBadip);
	/*
	 * No primary key defined in DB table!
	 */
}
