package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EdmBuyMark;

public interface EdmBuyMarkDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EdmBuyMark sEdmBuyMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EdmBuyMark sEdmBuyMark);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EdmBuyMark getEdmBuyMarkByKey(Integer userid);
}
