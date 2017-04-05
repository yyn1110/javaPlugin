package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WczMobile;

public interface WczMobileDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WczMobile sWczMobile);
	/*
	 * No primary key defined in DB table!
	 */
}
