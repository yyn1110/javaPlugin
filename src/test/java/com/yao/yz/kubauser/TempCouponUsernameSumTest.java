package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUsernameSum;
import com.yao.yz.kubauser.persistence.dao.TempCouponUsernameSumDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUsernameSumTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUsernameSum.class);
	@Autowired
	private TempCouponUsernameSumDao dao;

	private void setObjVal(TempCouponUsernameSum sObj) {
		sObj.setUsername("username");
		sObj.setDenomination(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUsernameSum objInsert = new TempCouponUsernameSum();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUsernameSum]");
		dao.insert(objInsert);
		String key = "username";
		TempCouponUsernameSum objSelect = dao.getTempCouponUsernameSumByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUsernameSumByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUsernameSumTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUsernameSumTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUsernameSumTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
