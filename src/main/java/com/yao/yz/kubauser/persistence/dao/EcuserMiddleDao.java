package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserMiddle;

public interface EcuserMiddleDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserMiddle sEcuserMiddle);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserMiddle sEcuserMiddle);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserMiddle getEcuserMiddleByKey(Integer userId);
}
