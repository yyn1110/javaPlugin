package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Tempusers;

public interface TempusersDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Tempusers sTempusers);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Tempusers sTempusers);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String username);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Tempusers getTempusersByKey(String username);
}
