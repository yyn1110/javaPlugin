package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczUserlogincount;

public interface WczUserlogincountDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczUserlogincount sWczUserlogincount);
	/*
	 * No primary key defined in DB table!
	 */
}
