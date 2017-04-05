package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinKeywordTemplate;

public interface WeixinKeywordTemplateDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinKeywordTemplate sWeixinKeywordTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinKeywordTemplate sWeixinKeywordTemplate);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinKeywordTemplate getWeixinKeywordTemplateByKey(Integer id);
}
