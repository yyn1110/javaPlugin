package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserOnlineuser;
import com.yao.yz.kubauser.persistence.dao.EcuserOnlineuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserOnlineuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserOnlineuser.class);
	@Autowired
	private EcuserOnlineuserDao dao;

	private void setObjVal(EcuserOnlineuser sObj) {
		sObj.setUserId(1);
		sObj.setUId(1);
		sObj.setUserName("userName");
		sObj.setNickName("nickName");
		sObj.setLoginTime(new java.util.Date());
		sObj.setLastTime(new java.util.Date());
		sObj.setLastActionUrl("lastActionUrl");
		sObj.setLoginIp("loginIp");
		sObj.setIsGuest(1);
		sObj.setSessionId("sessionId");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserOnlineuser objInsert = new EcuserOnlineuser();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserOnlineuser]");
		dao.insert(objInsert);
		Integer key = 1;
		EcuserOnlineuser objSelect = dao.getEcuserOnlineuserByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserOnlineuserByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserOnlineuserTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserOnlineuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserOnlineuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
