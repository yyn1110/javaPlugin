package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUser1;

public interface TempCouponUser1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUser1 sTempCouponUser1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUser1 sTempCouponUser1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUser1 getTempCouponUser1ByKey(String username);
}
