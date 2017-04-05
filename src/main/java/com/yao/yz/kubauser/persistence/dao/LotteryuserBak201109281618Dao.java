package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.LotteryuserBak201109281618;

public interface LotteryuserBak201109281618Dao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(LotteryuserBak201109281618 sLotteryuserBak201109281618);
	/*
	 * No primary key defined in DB table!
	 */
}
