package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.TempTelephone;

public interface TempTelephoneDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(TempTelephone sTempTelephone);
	/*
	 * No primary key defined in DB table!
	 */
}
