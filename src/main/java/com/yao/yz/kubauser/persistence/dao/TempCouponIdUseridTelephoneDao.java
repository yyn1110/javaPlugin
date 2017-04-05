package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponIdUseridTelephone;

public interface TempCouponIdUseridTelephoneDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponIdUseridTelephone sTempCouponIdUseridTelephone);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponIdUseridTelephone sTempCouponIdUseridTelephone);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponIdUseridTelephone getTempCouponIdUseridTelephoneByKey(Integer userid);
}
