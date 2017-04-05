package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcquyiShipto;

public interface EcquyiShiptoDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcquyiShipto sEcquyiShipto);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcquyiShipto sEcquyiShipto);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcquyiShipto getEcquyiShiptoByKey(Integer id);
}
