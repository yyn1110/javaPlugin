package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserPrivateCustomLog;
import com.yao.yz.kubauser.persistence.dao.EcuserPrivateCustomLogDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserPrivateCustomLogTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserPrivateCustomLog.class);
	@Autowired
	private EcuserPrivateCustomLogDao dao;

	private void setObjVal(EcuserPrivateCustomLog sObj) {
		sObj.setEcUserId(1);
		sObj.setPrivateCustom("privateCustom");
		sObj.setPrivateRole(1);
		sObj.setRoleCreateDate(new java.util.Date());
		sObj.setCustomCreateDate(new java.util.Date());
		sObj.setOperationType(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserPrivateCustomLog objInsert = new EcuserPrivateCustomLog();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserPrivateCustomLog]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserPrivateCustomLogTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserPrivateCustomLog objSelect = dao.getEcuserPrivateCustomLogByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserPrivateCustomLogTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserPrivateCustomLogTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserPrivateCustomLogTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
