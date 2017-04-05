package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserLoginuser;

public interface EcuserLoginuserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserLoginuser sEcuserLoginuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserLoginuser sEcuserLoginuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String token);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserLoginuser getEcuserLoginuserByKey(String token);
}
