package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EdmPush;
import com.yao.yz.kubauser.persistence.dao.EdmPushDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EdmPushTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EdmPush.class);
	@Autowired
	private EdmPushDao dao;

	private void setObjVal(EdmPush sObj) {
		sObj.setUserId(1);
		sObj.setPushEmail(1);
		sObj.setPushSms(1);
		sObj.setPushApp(1);
		sObj.setUsePc(1);
		sObj.setUseApp(1);
		sObj.setPPush("pPush");
		sObj.setUpdateTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EdmPush objInsert = new EdmPush();
		setObjVal(objInsert);

		LOGGER.info("+ [EdmPush]");
		dao.insert(objInsert);
		Integer key = 1;
		EdmPush objSelect = dao.getEdmPushByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEdmPushByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EdmPushTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EdmPushTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EdmPushTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
