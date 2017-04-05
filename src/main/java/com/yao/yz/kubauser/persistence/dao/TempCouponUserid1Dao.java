package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserid1;

public interface TempCouponUserid1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserid1 sTempCouponUserid1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUserid1 sTempCouponUserid1);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUserid1 getTempCouponUserid1ByKey(Integer userid);
}
