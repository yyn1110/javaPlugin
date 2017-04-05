package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserAccountOpen;

public interface EcuserAccountOpenDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserAccountOpen sEcuserAccountOpen);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserAccountOpen sEcuserAccountOpen);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer accountId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserAccountOpen getEcuserAccountOpenByKey(Integer accountId);
}
