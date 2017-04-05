package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserBak201310121831;

public interface EcuserCooperationuserBak201310121831Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCooperationuserBak201310121831 sEcuserCooperationuserBak201310121831);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCooperationuserBak201310121831 sEcuserCooperationuserBak201310121831);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCooperationuserBak201310121831 getEcuserCooperationuserBak201310121831ByKey(Integer id);
}
