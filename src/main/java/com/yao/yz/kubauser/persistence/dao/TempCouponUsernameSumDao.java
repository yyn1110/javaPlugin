package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUsernameSum;

public interface TempCouponUsernameSumDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUsernameSum sTempCouponUsernameSum);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUsernameSum sTempCouponUsernameSum);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUsernameSum getTempCouponUsernameSumByKey(String username);
}
