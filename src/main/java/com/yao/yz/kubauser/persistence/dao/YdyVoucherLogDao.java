package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.YdyVoucherLog;

public interface YdyVoucherLogDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(YdyVoucherLog sYdyVoucherLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(YdyVoucherLog sYdyVoucherLog);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public YdyVoucherLog getYdyVoucherLogByKey(Integer id);
}
