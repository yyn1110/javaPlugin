package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserIdentityuser;

public interface EcuserIdentityuserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserIdentityuser sEcuserIdentityuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserIdentityuser sEcuserIdentityuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserIdentityuser getEcuserIdentityuserByKey(Integer userId);
}
