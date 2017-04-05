package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.AaUseMark;

public interface AaUseMarkDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(AaUseMark sAaUseMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(AaUseMark sAaUseMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public AaUseMark getAaUseMarkByKey(Integer userid);
}
