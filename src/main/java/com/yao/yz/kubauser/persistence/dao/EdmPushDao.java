package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EdmPush;

public interface EdmPushDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EdmPush sEdmPush);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EdmPush sEdmPush);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EdmPush getEdmPushByKey(Integer userId);
}
