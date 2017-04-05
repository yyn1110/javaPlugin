package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Badip;

public interface BadipDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Badip sBadip);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Badip sBadip);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String 登录ip);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Badip getBadipByKey(String 登录ip);
}
