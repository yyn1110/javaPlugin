package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.B2cUserBlacklist;

public interface B2cUserBlacklistDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(B2cUserBlacklist sB2cUserBlacklist);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(B2cUserBlacklist sB2cUserBlacklist);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public B2cUserBlacklist getB2cUserBlacklistByKey(Integer id);
}
