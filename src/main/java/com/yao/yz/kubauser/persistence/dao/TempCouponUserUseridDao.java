package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUserUserid;

public interface TempCouponUserUseridDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUserUserid sTempCouponUserUserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUserUserid sTempCouponUserUserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUserUserid getTempCouponUserUseridByKey(Integer userId);
}
