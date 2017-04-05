package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Lotteryjoinuser;

public interface LotteryjoinuserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Lotteryjoinuser sLotteryjoinuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Lotteryjoinuser sLotteryjoinuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Lotteryjoinuser getLotteryjoinuserByKey(Integer id);
}
