package com.yao.yz.kubauser.persistence.dao;

import com.yao.yz.kubauser.dataSource.DataSource;
import com.yao.yz.kubauser.persistence.model.WeixinKeywords;

public interface WeixinKeywordsDao {
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int insert(WeixinKeywords sWeixinKeywords);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int update(WeixinKeywords sWeixinKeywords);
	@DataSource(DataSourceConstants.DATASOURCE_W_KUBAUSER)
	public int delete(Integer id);
	@DataSource(DataSourceConstants.DATASOURCE_R_KUBAUSER)
	public WeixinKeywords getWeixinKeywordsByKey(Integer id);
}
