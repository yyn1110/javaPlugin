package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerUseremail201007181141;

public interface EcuserCustomerUseremail201007181141Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerUseremail201007181141 sEcuserCustomerUseremail201007181141);
	/*
	 * No primary key defined in DB table!
	 */
}
