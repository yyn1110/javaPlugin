package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcquyiMedicine;

public interface EcquyiMedicineDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcquyiMedicine sEcquyiMedicine);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcquyiMedicine sEcquyiMedicine);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcquyiMedicine getEcquyiMedicineByKey(Integer id);
}
