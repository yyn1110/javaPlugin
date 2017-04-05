package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcextendAcceptaddress;

public interface EcextendAcceptaddressDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcextendAcceptaddress sEcextendAcceptaddress);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcextendAcceptaddress sEcextendAcceptaddress);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcextendAcceptaddress getEcextendAcceptaddressByKey(Integer id);
}
