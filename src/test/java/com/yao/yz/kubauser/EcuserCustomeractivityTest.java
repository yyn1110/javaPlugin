package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomeractivity;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomeractivityDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomeractivityTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomeractivity.class);
	@Autowired
	private EcuserCustomeractivityDao dao;

	private void setObjVal(EcuserCustomeractivity sObj) {
		sObj.setUserName("userName");
		sObj.setActivityCode("activityCode");
		sObj.setAddTime(new java.util.Date());
		sObj.setStatus(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomeractivity objInsert = new EcuserCustomeractivity();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomeractivity]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomeractivityTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomeractivity objSelect = dao.getEcuserCustomeractivityByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomeractivityTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomeractivityTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomeractivityTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
