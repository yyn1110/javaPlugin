package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempEdmusername;

public interface TempEdmusernameDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempEdmusername sTempEdmusername);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempEdmusername sTempEdmusername);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempEdmusername getTempEdmusernameByKey(String id);
}
