package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinUserBind;

public interface WeixinUserBindDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinUserBind sWeixinUserBind);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinUserBind sWeixinUserBind);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinUserBind getWeixinUserBindByKey(Integer id);
}
