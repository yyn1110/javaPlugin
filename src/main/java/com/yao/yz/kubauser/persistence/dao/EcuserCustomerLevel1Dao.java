package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerLevel1;

public interface EcuserCustomerLevel1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerLevel1 sEcuserCustomerLevel1);
	/*
	 * No primary key defined in DB table!
	 */
}
