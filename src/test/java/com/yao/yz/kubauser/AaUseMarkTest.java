package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.AaUseMark;
import com.yao.yz.kubauser.persistence.dao.AaUseMarkDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AaUseMarkTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(AaUseMark.class);
	@Autowired
	private AaUseMarkDao dao;

	private void setObjVal(AaUseMark sObj) {
		sObj.setUserid(1);
		sObj.setWeb(1);
		sObj.setApp(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		AaUseMark objInsert = new AaUseMark();
		setObjVal(objInsert);

		LOGGER.info("+ [AaUseMark]");
		dao.insert(objInsert);
		Integer key = 1;
		AaUseMark objSelect = dao.getAaUseMarkByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getAaUseMarkByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("AaUseMarkTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("AaUseMarkTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("AaUseMarkTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
