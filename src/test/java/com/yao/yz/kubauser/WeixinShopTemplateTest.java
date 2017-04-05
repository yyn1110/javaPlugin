package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinShopTemplate;
import com.yao.yz.kubauser.persistence.dao.WeixinShopTemplateDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinShopTemplateTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinShopTemplate.class);
	@Autowired
	private WeixinShopTemplateDao dao;

	private void setObjVal(WeixinShopTemplate sObj) {
		sObj.setShopId(1);
		sObj.setTemplateId(1);
		sObj.setExpire(new java.util.Date());
		sObj.setTemplateStatus(1);
		sObj.setIfFillTemplate(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinShopTemplate objInsert = new WeixinShopTemplate();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinShopTemplate]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinShopTemplateTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinShopTemplate objSelect = dao.getWeixinShopTemplateByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinShopTemplateTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinShopTemplateTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinShopTemplateTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
