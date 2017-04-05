package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserSina20111011;

public interface EcuserCooperationuserSina20111011Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCooperationuserSina20111011 sEcuserCooperationuserSina20111011);
	/*
	 * No primary key defined in DB table!
	 */
}
