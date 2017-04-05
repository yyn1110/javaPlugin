package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.Lotteryuserinfo;

public interface LotteryuserinfoDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(Lotteryuserinfo sLotteryuserinfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(Lotteryuserinfo sLotteryuserinfo);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public Lotteryuserinfo getLotteryuserinfoByKey(Integer id);
}
