package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczUserorder;

public interface WczUserorderDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczUserorder sWczUserorder);
	/*
	 * No primary key defined in DB table!
	 */
}
