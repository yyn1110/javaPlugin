package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.ZsjVenderUser;

public interface ZsjVenderUserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(ZsjVenderUser sZsjVenderUser);
	/*
	 * No primary key defined in DB table!
	 */
}
