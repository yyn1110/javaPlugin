package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.YdyRecipeLog;

public interface YdyRecipeLogDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(YdyRecipeLog sYdyRecipeLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(YdyRecipeLog sYdyRecipeLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public YdyRecipeLog getYdyRecipeLogByKey(Integer id);
}
