package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczScoreusername;

public interface WczScoreusernameDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczScoreusername sWczScoreusername);
	/*
	 * No primary key defined in DB table!
	 */
}
