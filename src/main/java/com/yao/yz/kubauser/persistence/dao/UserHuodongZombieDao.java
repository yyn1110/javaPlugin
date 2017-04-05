package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.UserHuodongZombie;

public interface UserHuodongZombieDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(UserHuodongZombie sUserHuodongZombie);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(UserHuodongZombie sUserHuodongZombie);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public UserHuodongZombie getUserHuodongZombieByKey(String id);
}
