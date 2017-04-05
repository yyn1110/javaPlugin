package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcUnableUseremail;

public interface EcUnableUseremailDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcUnableUseremail sEcUnableUseremail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcUnableUseremail sEcUnableUseremail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String email);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcUnableUseremail getEcUnableUseremailByKey(String email);
}
