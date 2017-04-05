package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerPrivilege;

public interface EcuserCustomerPrivilegeDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerPrivilege sEcuserCustomerPrivilege);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomerPrivilege sEcuserCustomerPrivilege);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String userName);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomerPrivilege getEcuserCustomerPrivilegeByKey(String userName);
}
