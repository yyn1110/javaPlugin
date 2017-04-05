package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.YdyVoucher;

public interface YdyVoucherDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(YdyVoucher sYdyVoucher);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(YdyVoucher sYdyVoucher);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public YdyVoucher getYdyVoucherByKey(Integer id);
}
