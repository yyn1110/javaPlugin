package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserLoginuserHistory20111123;
import com.yao.yz.kubauser.persistence.dao.EcuserLoginuserHistory20111123Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserLoginuserHistory20111123Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserLoginuserHistory20111123.class);
	@Autowired
	private EcuserLoginuserHistory20111123Dao dao;

	private void setObjVal(EcuserLoginuserHistory20111123 sObj) {
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
		EcuserLoginuserHistory20111123 objInsert = new EcuserLoginuserHistory20111123();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserLoginuserHistory20111123]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
