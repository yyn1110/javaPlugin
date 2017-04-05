package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.B2cUserIdentityCardInfo;
import com.yao.yz.kubauser.persistence.dao.B2cUserIdentityCardInfoDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class B2cUserIdentityCardInfoTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(B2cUserIdentityCardInfo.class);
	@Autowired
	private B2cUserIdentityCardInfoDao dao;

	private void setObjVal(B2cUserIdentityCardInfo sObj) {
		sObj.setEcUserId(1);
		sObj.setUserName("userName");
		sObj.setIdentityName("identityName");
		sObj.setIdentityCard("identityCard");
		sObj.setIdentityObverseImg("identityObverseImg");
		sObj.setIdentityReverseImg("identityReverseImg");
		sObj.setCreateUserId("createUserId");
		sObj.setCreateDate(new java.util.Date());
		sObj.setUpdateUserId("updateUserId");
		sObj.setUpdateDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		B2cUserIdentityCardInfo objInsert = new B2cUserIdentityCardInfo();
		setObjVal(objInsert);

		LOGGER.info("+ [B2cUserIdentityCardInfo]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("B2cUserIdentityCardInfoTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		B2cUserIdentityCardInfo objSelect = dao.getB2cUserIdentityCardInfoByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("B2cUserIdentityCardInfoTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("B2cUserIdentityCardInfoTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("B2cUserIdentityCardInfoTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
