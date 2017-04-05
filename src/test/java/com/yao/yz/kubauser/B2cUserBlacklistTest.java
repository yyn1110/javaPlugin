package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.B2cUserBlacklist;
import com.yao.yz.kubauser.persistence.dao.B2cUserBlacklistDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class B2cUserBlacklistTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(B2cUserBlacklist.class);
	@Autowired
	private B2cUserBlacklistDao dao;

	private void setObjVal(B2cUserBlacklist sObj) {
		sObj.setEcUserId(1);
		sObj.setUserName("userName");
		sObj.setUserMobile("userMobile");
		sObj.setUserEmail("userEmail");
		sObj.setBlacklistType("bla");
		sObj.setBlacklistStatus("bla");
		sObj.setCreateUserId("createUserId");
		sObj.setCreateDate(new java.util.Date());
		sObj.setUpdateUserId("updateUserId");
		sObj.setUpdateDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		B2cUserBlacklist objInsert = new B2cUserBlacklist();
		setObjVal(objInsert);

		LOGGER.info("+ [B2cUserBlacklist]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("B2cUserBlacklistTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		B2cUserBlacklist objSelect = dao.getB2cUserBlacklistByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("B2cUserBlacklistTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("B2cUserBlacklistTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("B2cUserBlacklistTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
