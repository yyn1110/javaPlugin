package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUser;

public interface TempCouponUserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUser sTempCouponUser);
	/*
	 * No primary key defined in DB table!
	 */
}
