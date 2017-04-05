package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempEdmEmail;

public interface TempEdmEmailDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempEdmEmail sTempEdmEmail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempEdmEmail sTempEdmEmail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String emailAddress);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempEdmEmail getTempEdmEmailByKey(String emailAddress);
}
