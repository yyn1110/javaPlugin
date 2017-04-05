package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerGivescore;

public interface EcuserCustomerGivescoreDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerGivescore sEcuserCustomerGivescore);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomerGivescore sEcuserCustomerGivescore);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer iD);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomerGivescore getEcuserCustomerGivescoreByKey(Integer iD);
}
