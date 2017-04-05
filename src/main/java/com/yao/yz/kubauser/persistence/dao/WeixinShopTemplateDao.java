package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinShopTemplate;

public interface WeixinShopTemplateDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinShopTemplate sWeixinShopTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinShopTemplate sWeixinShopTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinShopTemplate getWeixinShopTemplateByKey(Integer id);
}
