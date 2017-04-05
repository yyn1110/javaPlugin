package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcquyiPatient;

public interface EcquyiPatientDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcquyiPatient sEcquyiPatient);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcquyiPatient sEcquyiPatient);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcquyiPatient getEcquyiPatientByKey(Integer id);
}
