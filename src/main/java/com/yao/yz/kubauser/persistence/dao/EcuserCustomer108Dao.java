package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomer108;

public interface EcuserCustomer108Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomer108 sEcuserCustomer108);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomer108 sEcuserCustomer108);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer ecUserId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomer108 getEcuserCustomer108ByKey(Integer ecUserId);
}
