package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerRe;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerReDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerReTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerRe.class);
	@Autowired
	private EcuserCustomerReDao dao;

	private void setObjVal(EcuserCustomerRe sObj) {
		sObj.setPassword("password");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerRe objInsert = new EcuserCustomerRe();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerRe]");
		dao.insert(objInsert);
		Integer key = objInsert.getEcuserid();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerReTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerRe objSelect = dao.getEcuserCustomerReByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerReTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerReTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerReTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
