package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserPrivateCustomLog;

public interface EcuserPrivateCustomLogDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserPrivateCustomLog sEcuserPrivateCustomLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserPrivateCustomLog sEcuserPrivateCustomLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserPrivateCustomLog getEcuserPrivateCustomLogByKey(Integer id);
}
