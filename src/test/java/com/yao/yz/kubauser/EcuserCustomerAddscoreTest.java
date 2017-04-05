package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerAddscore;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerAddscoreDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerAddscoreTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerAddscore.class);
	@Autowired
	private EcuserCustomerAddscoreDao dao;

	private void setObjVal(EcuserCustomerAddscore sObj) {
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setScore(1);
		sObj.setRunflag(1);
		sObj.setAddTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerAddscore objInsert = new EcuserCustomerAddscore();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerAddscore]");
		dao.insert(objInsert);
		String key = "userName";
		EcuserCustomerAddscore objSelect = dao.getEcuserCustomerAddscoreByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserCustomerAddscoreByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerAddscoreTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerAddscoreTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerAddscoreTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
