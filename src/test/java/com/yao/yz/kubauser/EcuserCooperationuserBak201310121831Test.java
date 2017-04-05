package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserBak201310121831;
import com.yao.yz.kubauser.persistence.dao.EcuserCooperationuserBak201310121831Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCooperationuserBak201310121831Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCooperationuserBak201310121831.class);
	@Autowired
	private EcuserCooperationuserBak201310121831Dao dao;

	private void setObjVal(EcuserCooperationuserBak201310121831 sObj) {
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
		EcuserCooperationuserBak201310121831 objInsert = new EcuserCooperationuserBak201310121831();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCooperationuserBak201310121831]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCooperationuserBak201310121831Test", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCooperationuserBak201310121831 objSelect = dao.getEcuserCooperationuserBak201310121831ByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCooperationuserBak201310121831Test", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCooperationuserBak201310121831Test", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCooperationuserBak201310121831Test", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
