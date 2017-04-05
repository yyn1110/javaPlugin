package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempCostomermobile20110930;

public interface TempCostomermobile20110930Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempCostomermobile20110930 sTempCostomermobile20110930);
	/*
	 * No primary key defined in DB table!
	 */
}
