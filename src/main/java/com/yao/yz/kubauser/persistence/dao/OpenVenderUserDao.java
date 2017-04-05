package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.OpenVenderUser;

public interface OpenVenderUserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(OpenVenderUser sOpenVenderUser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(OpenVenderUser sOpenVenderUser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public OpenVenderUser getOpenVenderUserByKey(Integer id);
}
