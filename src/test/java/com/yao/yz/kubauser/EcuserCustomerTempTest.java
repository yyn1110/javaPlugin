package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerTemp;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerTempDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerTempTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerTemp.class);
	@Autowired
	private EcuserCustomerTempDao dao;

	private void setObjVal(EcuserCustomerTemp sObj) {
		sObj.setId("id");
		sObj.setEmail("email");
		sObj.setCount(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerTemp objInsert = new EcuserCustomerTemp();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerTemp]");
		dao.insert(objInsert);
		Integer key = objInsert.getEcuserid();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerTempTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerTemp objSelect = dao.getEcuserCustomerTempByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerTempTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerTempTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerTempTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
