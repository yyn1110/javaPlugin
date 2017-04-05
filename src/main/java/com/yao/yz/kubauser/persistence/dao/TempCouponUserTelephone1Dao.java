package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserTelephone1;

public interface TempCouponUserTelephone1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserTelephone1 sTempCouponUserTelephone1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUserTelephone1 sTempCouponUserTelephone1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String telephone);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUserTelephone1 getTempCouponUserTelephone1ByKey(String telephone);
}
