package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerPrivilege;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerPrivilegeDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerPrivilegeTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerPrivilege.class);
	@Autowired
	private EcuserCustomerPrivilegeDao dao;

	private void setObjVal(EcuserCustomerPrivilege sObj) {
		sObj.setUserName("userName");
		sObj.setOldScore(1);
		sObj.setNewScore(1);
		sObj.setRunFlag(1);
		sObj.setId(1);
		sObj.setLatestScore(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerPrivilege objInsert = new EcuserCustomerPrivilege();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerPrivilege]");
		dao.insert(objInsert);
		String key = "userName";
		EcuserCustomerPrivilege objSelect = dao.getEcuserCustomerPrivilegeByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserCustomerPrivilegeByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerPrivilegeTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerPrivilegeTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerPrivilegeTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
