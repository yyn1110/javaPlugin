package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserUpdateuserauthinfologs;

public interface EcuserUpdateuserauthinfologsDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserUpdateuserauthinfologs sEcuserUpdateuserauthinfologs);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserUpdateuserauthinfologs sEcuserUpdateuserauthinfologs);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserUpdateuserauthinfologs getEcuserUpdateuserauthinfologsByKey(Integer id);
}
