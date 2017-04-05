package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserAccountAdd;
import com.yao.yz.kubauser.persistence.dao.EcuserAccountAddDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserAccountAddTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserAccountAdd.class);
	@Autowired
	private EcuserAccountAddDao dao;

	private void setObjVal(EcuserAccountAdd sObj) {
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
		EcuserAccountAdd objInsert = new EcuserAccountAdd();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserAccountAdd]");
		dao.insert(objInsert);
		Integer key = objInsert.getAccountId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserAccountAddTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserAccountAdd objSelect = dao.getEcuserAccountAddByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserAccountAddTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserAccountAddTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserAccountAddTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
