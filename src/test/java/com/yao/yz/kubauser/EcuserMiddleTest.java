package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserMiddle;
import com.yao.yz.kubauser.persistence.dao.EcuserMiddleDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserMiddleTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserMiddle.class);
	@Autowired
	private EcuserMiddleDao dao;

	private void setObjVal(EcuserMiddle sObj) {
		sObj.setUserId(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserMiddle objInsert = new EcuserMiddle();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserMiddle]");
		dao.insert(objInsert);
		Integer key = 1;
		EcuserMiddle objSelect = dao.getEcuserMiddleByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserMiddleByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserMiddleTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserMiddleTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserMiddleTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
