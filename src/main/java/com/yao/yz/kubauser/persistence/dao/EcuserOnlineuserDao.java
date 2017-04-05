package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserOnlineuser;

public interface EcuserOnlineuserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserOnlineuser sEcuserOnlineuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserOnlineuser sEcuserOnlineuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserOnlineuser getEcuserOnlineuserByKey(Integer userId);
}
