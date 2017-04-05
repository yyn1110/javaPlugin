package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.EcuserTmallTemp;

public interface EcuserTmallTempDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(EcuserTmallTemp sEcuserTmallTemp);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(EcuserTmallTemp sEcuserTmallTemp);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer ecuserid);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public EcuserTmallTemp getEcuserTmallTempByKey(Integer ecuserid);
}
