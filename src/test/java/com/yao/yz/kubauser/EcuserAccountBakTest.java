package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserAccountBak;
import com.yao.yz.kubauser.persistence.dao.EcuserAccountBakDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserAccountBakTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserAccountBak.class);
	@Autowired
	private EcuserAccountBakDao dao;

	private void setObjVal(EcuserAccountBak sObj) {
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
		EcuserAccountBak objInsert = new EcuserAccountBak();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserAccountBak]");
		dao.insert(objInsert);
		Integer key = objInsert.getAccountId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserAccountBakTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserAccountBak objSelect = dao.getEcuserAccountBakByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserAccountBakTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserAccountBakTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserAccountBakTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
