package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserCustomerRecord;

public interface EcuserCustomerRecordDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserCustomerRecord sEcuserCustomerRecord);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserCustomerRecord sEcuserCustomerRecord);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserCustomerRecord getEcuserCustomerRecordByKey(Integer id);
}
