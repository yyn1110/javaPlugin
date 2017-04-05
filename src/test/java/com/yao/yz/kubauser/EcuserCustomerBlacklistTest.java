package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerBlacklist;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerBlacklistDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerBlacklistTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerBlacklist.class);
	@Autowired
	private EcuserCustomerBlacklistDao dao;

	private void setObjVal(EcuserCustomerBlacklist sObj) {
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setMobile("mobile");
		sObj.setTel("tel");
		sObj.setUserIp("userIp");
		sObj.setCreator("creator");
		sObj.setCreateTime(new java.util.Date());
		sObj.setIsDeleted(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerBlacklist objInsert = new EcuserCustomerBlacklist();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerBlacklist]");
		dao.insert(objInsert);
		Integer key = objInsert.getAutoId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerBlacklistTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerBlacklist objSelect = dao.getEcuserCustomerBlacklistByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerBlacklistTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerBlacklistTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerBlacklistTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
