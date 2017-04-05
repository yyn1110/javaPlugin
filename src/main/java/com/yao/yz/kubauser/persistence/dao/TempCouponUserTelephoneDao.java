package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserTelephone;

public interface TempCouponUserTelephoneDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserTelephone sTempCouponUserTelephone);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUserTelephone sTempCouponUserTelephone);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String telephone);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUserTelephone getTempCouponUserTelephoneByKey(String telephone);
}
