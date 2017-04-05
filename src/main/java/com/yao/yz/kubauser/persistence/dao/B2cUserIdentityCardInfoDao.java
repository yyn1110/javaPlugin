package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.B2cUserIdentityCardInfo;

public interface B2cUserIdentityCardInfoDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(B2cUserIdentityCardInfo sB2cUserIdentityCardInfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(B2cUserIdentityCardInfo sB2cUserIdentityCardInfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public B2cUserIdentityCardInfo getB2cUserIdentityCardInfoByKey(Integer id);
}
