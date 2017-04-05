package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserAccountAdd;

public interface EcuserAccountAddDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserAccountAdd sEcuserAccountAdd);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserAccountAdd sEcuserAccountAdd);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer accountId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserAccountAdd getEcuserAccountAddByKey(Integer accountId);
}
