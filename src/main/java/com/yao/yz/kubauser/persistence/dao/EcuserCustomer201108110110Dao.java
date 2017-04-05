package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomer201108110110;

public interface EcuserCustomer201108110110Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomer201108110110 sEcuserCustomer201108110110);
	/*
	 * No primary key defined in DB table!
	 */
}
