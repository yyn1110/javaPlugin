package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.BtocCouponTouser;

public interface BtocCouponTouserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(BtocCouponTouser sBtocCouponTouser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(BtocCouponTouser sBtocCouponTouser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public BtocCouponTouser getBtocCouponTouserByKey(Integer id);
}
