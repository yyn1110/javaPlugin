package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczOrder2000;

public interface WczOrder2000Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczOrder2000 sWczOrder2000);
	/*
	 * No primary key defined in DB table!
	 */
}
