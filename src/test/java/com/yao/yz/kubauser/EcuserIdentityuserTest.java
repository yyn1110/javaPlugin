package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserIdentityuser;
import com.yao.yz.kubauser.persistence.dao.EcuserIdentityuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserIdentityuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserIdentityuser.class);
	@Autowired
	private EcuserIdentityuserDao dao;

	private void setObjVal(EcuserIdentityuser sObj) {
		sObj.setUserId(1);
		sObj.setUId(1);
		sObj.setUserName("userName");
		sObj.setCurrentRole("currentRole");
		sObj.setUserLevelId(1);
		sObj.setUserLevelName("userLevelName");
		sObj.setUserScore(1);
		sObj.setAccountFee(new java.math.BigDecimal(1.0));
		sObj.setOrderFinishCount(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserIdentityuser objInsert = new EcuserIdentityuser();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserIdentityuser]");
		dao.insert(objInsert);
		Integer key = 1;
		EcuserIdentityuser objSelect = dao.getEcuserIdentityuserByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserIdentityuserByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserIdentityuserTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserIdentityuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserIdentityuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
