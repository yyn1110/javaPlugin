package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.CouponUserMiddle;

public interface CouponUserMiddleDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(CouponUserMiddle sCouponUserMiddle);
	/*
	 * No primary key defined in DB table!
	 */
}
