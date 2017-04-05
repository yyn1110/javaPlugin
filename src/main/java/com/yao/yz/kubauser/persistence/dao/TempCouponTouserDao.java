package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponTouser;

public interface TempCouponTouserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponTouser sTempCouponTouser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponTouser sTempCouponTouser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponTouser getTempCouponTouserByKey(String username);
}
