package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserCopy;

public interface TempCouponUserCopyDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserCopy sTempCouponUserCopy);
	/*
	 * No primary key defined in DB table!
	 */
}
