package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerRebak;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerRebakDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerRebakTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerRebak.class);
	@Autowired
	private EcuserCustomerRebakDao dao;

	private void setObjVal(EcuserCustomerRebak sObj) {
		sObj.setPassword("password");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerRebak objInsert = new EcuserCustomerRebak();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerRebak]");
		dao.insert(objInsert);
		Integer key = objInsert.getEcuserid();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerRebakTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerRebak objSelect = dao.getEcuserCustomerRebakByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerRebakTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerRebakTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerRebakTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
