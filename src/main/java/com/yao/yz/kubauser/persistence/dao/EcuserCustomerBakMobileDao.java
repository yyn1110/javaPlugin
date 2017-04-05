package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerBakMobile;

public interface EcuserCustomerBakMobileDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerBakMobile sEcuserCustomerBakMobile);
	/*
	 * No primary key defined in DB table!
	 */
}
