package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinKeywords;
import com.yao.yz.kubauser.persistence.dao.WeixinKeywordsDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinKeywordsTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinKeywords.class);
	@Autowired
	private WeixinKeywordsDao dao;

	private void setObjVal(WeixinKeywords sObj) {
		sObj.setShowName("showName");
		sObj.setContent("content");
		sObj.setType("type");
		sObj.setCategory("category");
		sObj.setShopId(1);
		sObj.setReplyType("replyType");
		sObj.setReplyMethod("replyMetho");
		sObj.setStatus(1);
		sObj.setInputeDate(new java.util.Date());
		sObj.setInputer("inputer");
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinKeywords objInsert = new WeixinKeywords();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinKeywords]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinKeywordsTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinKeywords objSelect = dao.getWeixinKeywordsByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinKeywordsTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinKeywordsTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinKeywordsTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
