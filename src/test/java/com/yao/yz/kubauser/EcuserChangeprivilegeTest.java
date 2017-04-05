package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserChangeprivilege;
import com.yao.yz.kubauser.persistence.dao.EcuserChangeprivilegeDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserChangeprivilegeTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserChangeprivilege.class);
	@Autowired
	private EcuserChangeprivilegeDao dao;

	private void setObjVal(EcuserChangeprivilege sObj) {
		sObj.setUserName("userName");
		sObj.setPrice(1);
		sObj.setCount(1);
		sObj.setSuccessCount(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserChangeprivilege objInsert = new EcuserChangeprivilege();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserChangeprivilege]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserChangeprivilegeTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserChangeprivilege objSelect = dao.getEcuserChangeprivilegeByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserChangeprivilegeTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserChangeprivilegeTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserChangeprivilegeTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
