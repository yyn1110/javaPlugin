package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserAlipay20111011;

public interface EcuserCooperationuserAlipay20111011Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCooperationuserAlipay20111011 sEcuserCooperationuserAlipay20111011);
	/*
	 * No primary key defined in DB table!
	 */
}
