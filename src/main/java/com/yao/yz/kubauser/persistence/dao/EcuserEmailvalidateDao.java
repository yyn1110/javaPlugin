package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserEmailvalidate;

public interface EcuserEmailvalidateDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserEmailvalidate sEcuserEmailvalidate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserEmailvalidate sEcuserEmailvalidate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer iD);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserEmailvalidate getEcuserEmailvalidateByKey(Integer iD);
}
