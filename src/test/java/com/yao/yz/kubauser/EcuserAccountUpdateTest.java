package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserAccountUpdate;
import com.yao.yz.kubauser.persistence.dao.EcuserAccountUpdateDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserAccountUpdateTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserAccountUpdate.class);
	@Autowired
	private EcuserAccountUpdateDao dao;

	private void setObjVal(EcuserAccountUpdate sObj) {
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
		EcuserAccountUpdate objInsert = new EcuserAccountUpdate();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserAccountUpdate]");
		dao.insert(objInsert);
		Integer key = objInsert.getAccountId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserAccountUpdateTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserAccountUpdate objSelect = dao.getEcuserAccountUpdateByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserAccountUpdateTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserAccountUpdateTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserAccountUpdateTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
