package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserAdd;
import com.yao.yz.kubauser.persistence.dao.EcuserCooperationuserAddDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCooperationuserAddTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCooperationuserAdd.class);
	@Autowired
	private EcuserCooperationuserAddDao dao;

	private void setObjVal(EcuserCooperationuserAdd sObj) {
		sObj.setPlatform("platform");
		sObj.setOutUserId("outUserId");
		sObj.setLoginName("loginName");
		sObj.setRealName("realName");
		sObj.setNickName("nickName");
		sObj.setMobile("mobile");
		sObj.setTelphone("telphone");
		sObj.setEmail("email");
		sObj.setBirthday(new java.util.Date());
		sObj.setOriginalParameter("originalParameter");
		sObj.setKubaUserId(1);
		sObj.setAddTime(new java.util.Date());
		sObj.setStatus(1);
		sObj.setGender(1);
		sObj.setUserSafeKey("userSafeKey");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCooperationuserAdd objInsert = new EcuserCooperationuserAdd();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCooperationuserAdd]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCooperationuserAddTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCooperationuserAdd objSelect = dao.getEcuserCooperationuserAddByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCooperationuserAddTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCooperationuserAddTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCooperationuserAddTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
