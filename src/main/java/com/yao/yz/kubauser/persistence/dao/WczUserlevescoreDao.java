package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczUserlevescore;

public interface WczUserlevescoreDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczUserlevescore sWczUserlevescore);
	/*
	 * No primary key defined in DB table!
	 */
}
