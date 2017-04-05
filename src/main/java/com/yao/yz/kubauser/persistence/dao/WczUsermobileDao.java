package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczUsermobile;

public interface WczUsermobileDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczUsermobile sWczUsermobile);
	/*
	 * No primary key defined in DB table!
	 */
}
