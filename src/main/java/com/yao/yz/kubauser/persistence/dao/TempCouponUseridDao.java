package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserid;

public interface TempCouponUseridDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserid sTempCouponUserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUserid sTempCouponUserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUserid getTempCouponUseridByKey(String userid);
}
