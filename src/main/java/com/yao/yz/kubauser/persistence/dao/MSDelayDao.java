package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.MSDelay;

public interface MSDelayDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(MSDelay sMSDelay);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(MSDelay sMSDelay);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public MSDelay getMSDelayByKey(Integer id);
}
