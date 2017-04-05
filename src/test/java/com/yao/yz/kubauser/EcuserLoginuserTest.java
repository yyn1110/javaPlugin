package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserLoginuser;
import com.yao.yz.kubauser.persistence.dao.EcuserLoginuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserLoginuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserLoginuser.class);
	@Autowired
	private EcuserLoginuserDao dao;

	private void setObjVal(EcuserLoginuser sObj) {
		sObj.setToken("token");
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setLoginTime(new java.util.Date());
		sObj.setExpiredTime(new java.util.Date());
		sObj.setUserIp("userIp");
		sObj.setLogoutTime(new java.util.Date());
		sObj.setIsUse(1);
		sObj.setSessionId("sessionId");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserLoginuser objInsert = new EcuserLoginuser();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserLoginuser]");
		dao.insert(objInsert);
		String key = "token";
		EcuserLoginuser objSelect = dao.getEcuserLoginuserByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserLoginuserByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserLoginuserTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserLoginuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserLoginuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
