package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczOrder;

public interface WczOrderDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczOrder sWczOrder);
	/*
	 * No primary key defined in DB table!
	 */
}
