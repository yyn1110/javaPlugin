package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserAccountBak;

public interface EcuserAccountBakDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserAccountBak sEcuserAccountBak);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserAccountBak sEcuserAccountBak);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer accountId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserAccountBak getEcuserAccountBakByKey(Integer accountId);
}
