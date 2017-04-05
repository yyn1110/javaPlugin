package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserBaidu20111011;

public interface EcuserCooperationuserBaidu20111011Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCooperationuserBaidu20111011 sEcuserCooperationuserBaidu20111011);
	/*
	 * No primary key defined in DB table!
	 */
}
