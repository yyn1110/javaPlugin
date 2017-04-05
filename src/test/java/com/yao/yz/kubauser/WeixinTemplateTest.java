package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinTemplate;
import com.yao.yz.kubauser.persistence.dao.WeixinTemplateDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinTemplateTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinTemplate.class);
	@Autowired
	private WeixinTemplateDao dao;

	private void setObjVal(WeixinTemplate sObj) {
		sObj.setTemplateContent("templateContent");
		sObj.setTemplateType("templateType");
		sObj.setInputer("inputer");
		sObj.setInputeDate(new java.util.Date());
		sObj.setPrice(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinTemplate objInsert = new WeixinTemplate();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinTemplate]");
		dao.insert(objInsert);
		Integer key = objInsert.getTemplateId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinTemplateTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinTemplate objSelect = dao.getWeixinTemplateByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinTemplateTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinTemplateTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinTemplateTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
