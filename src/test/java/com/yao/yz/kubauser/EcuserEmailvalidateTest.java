package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserEmailvalidate;
import com.yao.yz.kubauser.persistence.dao.EcuserEmailvalidateDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserEmailvalidateTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserEmailvalidate.class);
	@Autowired
	private EcuserEmailvalidateDao dao;

	private void setObjVal(EcuserEmailvalidate sObj) {
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setAddTime(new java.util.Date());
		sObj.setExpiredTime(new java.util.Date());
		sObj.setKeyCode("keyCode");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserEmailvalidate objInsert = new EcuserEmailvalidate();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserEmailvalidate]");
		dao.insert(objInsert);
		Integer key = objInsert.getID();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserEmailvalidateTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserEmailvalidate objSelect = dao.getEcuserEmailvalidateByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserEmailvalidateTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserEmailvalidateTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserEmailvalidateTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
