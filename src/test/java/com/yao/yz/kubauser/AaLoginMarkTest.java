package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.AaLoginMark;
import com.yao.yz.kubauser.persistence.dao.AaLoginMarkDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AaLoginMarkTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(AaLoginMark.class);
	@Autowired
	private AaLoginMarkDao dao;

	private void setObjVal(AaLoginMark sObj) {
		sObj.setUserid(1);
		sObj.setWeb(1);
		sObj.setApp(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		AaLoginMark objInsert = new AaLoginMark();
		setObjVal(objInsert);

		LOGGER.info("+ [AaLoginMark]");
		dao.insert(objInsert);
		Integer key = 1;
		AaLoginMark objSelect = dao.getAaLoginMarkByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getAaLoginMarkByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("AaLoginMarkTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("AaLoginMarkTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("AaLoginMarkTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
