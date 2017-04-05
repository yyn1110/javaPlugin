package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.CustomerMiddle;

public interface CustomerMiddleDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(CustomerMiddle sCustomerMiddle);
	/*
	 * No primary key defined in DB table!
	 */
}
