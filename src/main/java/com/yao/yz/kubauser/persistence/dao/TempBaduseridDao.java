package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempBaduserid;

public interface TempBaduseridDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempBaduserid sTempBaduserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(TempBaduserid sTempBaduserid);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer userid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public TempBaduserid getTempBaduseridByKey(Integer userid);
}
