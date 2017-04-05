package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Useremail;

public interface UseremailDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Useremail sUseremail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Useremail sUseremail);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(String email);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Useremail getUseremailByKey(String email);
}
