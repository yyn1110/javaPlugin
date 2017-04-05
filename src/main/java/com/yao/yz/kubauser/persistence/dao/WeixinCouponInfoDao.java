package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinCouponInfo;

public interface WeixinCouponInfoDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinCouponInfo sWeixinCouponInfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinCouponInfo sWeixinCouponInfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinCouponInfo getWeixinCouponInfoByKey(Integer id);
}
