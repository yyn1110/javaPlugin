package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Lotteryuser;

public interface LotteryuserDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Lotteryuser sLotteryuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Lotteryuser sLotteryuser);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Lotteryuser getLotteryuserByKey(Integer id);
}
