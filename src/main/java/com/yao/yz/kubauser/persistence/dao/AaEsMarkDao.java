package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.AaEsMark;

public interface AaEsMarkDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(AaEsMark sAaEsMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(AaEsMark sAaEsMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public AaEsMark getAaEsMarkByKey(Integer userid);
}
