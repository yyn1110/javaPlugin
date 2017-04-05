package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserAccount;

public interface EcuserAccountDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserAccount sEcuserAccount);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserAccount sEcuserAccount);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer accountId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserAccount getEcuserAccountByKey(Integer accountId);
}
