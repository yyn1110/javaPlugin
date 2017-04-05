package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinTemplate;

public interface WeixinTemplateDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinTemplate sWeixinTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinTemplate sWeixinTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer templateId);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinTemplate getWeixinTemplateByKey(Integer templateId);
}
