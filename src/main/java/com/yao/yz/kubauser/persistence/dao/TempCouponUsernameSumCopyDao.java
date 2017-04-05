package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCouponUsernameSumCopy;

public interface TempCouponUsernameSumCopyDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCouponUsernameSumCopy sTempCouponUsernameSumCopy);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempCouponUsernameSumCopy sTempCouponUsernameSumCopy);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempCouponUsernameSumCopy getTempCouponUsernameSumCopyByKey(String username);
}
