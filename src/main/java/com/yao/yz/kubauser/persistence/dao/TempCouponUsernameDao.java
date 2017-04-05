package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUsername;

public interface TempCouponUsernameDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUsername sTempCouponUsername);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUsername sTempCouponUsername);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUsername getTempCouponUsernameByKey(String username);
}
