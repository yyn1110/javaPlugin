package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinKeywordTemplate;
import com.yao.yz.kubauser.persistence.dao.WeixinKeywordTemplateDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinKeywordTemplateTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinKeywordTemplate.class);
	@Autowired
	private WeixinKeywordTemplateDao dao;

	private void setObjVal(WeixinKeywordTemplate sObj) {
		sObj.setKeyWordId(1);
		sObj.setTemplateId(1);
		sObj.setInputeDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinKeywordTemplate objInsert = new WeixinKeywordTemplate();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinKeywordTemplate]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinKeywordTemplateTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinKeywordTemplate objSelect = dao.getWeixinKeywordTemplateByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinKeywordTemplateTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinKeywordTemplateTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinKeywordTemplateTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
