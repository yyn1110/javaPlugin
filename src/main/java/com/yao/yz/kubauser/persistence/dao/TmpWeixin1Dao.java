package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TmpWeixin1;

public interface TmpWeixin1Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TmpWeixin1 sTmpWeixin1);
	/*
	 * No primary key defined in DB table!
	 */
}
