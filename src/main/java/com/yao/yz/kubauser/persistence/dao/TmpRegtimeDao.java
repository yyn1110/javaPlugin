package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TmpRegtime;

public interface TmpRegtimeDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TmpRegtime sTmpRegtime);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TmpRegtime sTmpRegtime);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String name);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TmpRegtime getTmpRegtimeByKey(String name);
}
