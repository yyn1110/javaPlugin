package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCooperationuser;
import com.yao.yz.kubauser.persistence.dao.EcuserCooperationuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCooperationuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCooperationuser.class);
	@Autowired
	private EcuserCooperationuserDao dao;

	private void setObjVal(EcuserCooperationuser sObj) {
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
		EcuserCooperationuser objInsert = new EcuserCooperationuser();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCooperationuser]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCooperationuserTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCooperationuser objSelect = dao.getEcuserCooperationuserByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCooperationuserTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCooperationuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCooperationuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
