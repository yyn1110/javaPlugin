package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczScoreusernameRegister;

public interface WczScoreusernameRegisterDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczScoreusernameRegister sWczScoreusernameRegister);
	/*
	 * No primary key defined in DB table!
	 */
}
