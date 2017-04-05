package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUsername;
import com.yao.yz.kubauser.persistence.dao.TempCouponUsernameDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUsernameTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUsername.class);
	@Autowired
	private TempCouponUsernameDao dao;

	private void setObjVal(TempCouponUsername sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUsername objInsert = new TempCouponUsername();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUsername]");
		dao.insert(objInsert);
		String key = "username";
		TempCouponUsername objSelect = dao.getTempCouponUsernameByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUsernameByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUsernameTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUsernameTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUsernameTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
