package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerBlacklist;

public interface EcuserCustomerBlacklistDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerBlacklist sEcuserCustomerBlacklist);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomerBlacklist sEcuserCustomerBlacklist);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer autoId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomerBlacklist getEcuserCustomerBlacklistByKey(Integer autoId);
}
