package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerAddscore;

public interface EcuserCustomerAddscoreDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerAddscore sEcuserCustomerAddscore);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomerAddscore sEcuserCustomerAddscore);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String userName);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomerAddscore getEcuserCustomerAddscoreByKey(String userName);
}
