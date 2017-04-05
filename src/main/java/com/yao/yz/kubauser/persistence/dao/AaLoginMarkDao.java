package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.AaLoginMark;

public interface AaLoginMarkDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(AaLoginMark sAaLoginMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(AaLoginMark sAaLoginMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public AaLoginMark getAaLoginMarkByKey(Integer userid);
}
