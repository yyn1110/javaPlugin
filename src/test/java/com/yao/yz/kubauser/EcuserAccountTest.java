package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserAccount;
import com.yao.yz.kubauser.persistence.dao.EcuserAccountDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserAccountTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserAccount.class);
	@Autowired
	private EcuserAccountDao dao;

	private void setObjVal(EcuserAccount sObj) {
		sObj.setEcuserId(1);
		sObj.setAccount(1.0);
		sObj.setFreezeAccount(1.0);
		sObj.setBackCount(1.0);
		sObj.setFreezeBackCount(1.0);
		sObj.setLastModifyDate(new java.util.Date());
		sObj.setUserName("userName");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserAccount objInsert = new EcuserAccount();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserAccount]");
		dao.insert(objInsert);
		Integer key = objInsert.getAccountId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserAccountTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserAccount objSelect = dao.getEcuserAccountByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserAccountTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserAccountTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserAccountTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
