package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerGivescore;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerGivescoreDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerGivescoreTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerGivescore.class);
	@Autowired
	private EcuserCustomerGivescoreDao dao;

	private void setObjVal(EcuserCustomerGivescore sObj) {
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setScore(1);
		sObj.setRunflag(1);
		sObj.setAddTime(new java.util.Date());
		sObj.setSysComment("sysComment");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerGivescore objInsert = new EcuserCustomerGivescore();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerGivescore]");
		dao.insert(objInsert);
		Integer key = objInsert.getID();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerGivescoreTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerGivescore objSelect = dao.getEcuserCustomerGivescoreByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerGivescoreTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerGivescoreTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerGivescoreTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
