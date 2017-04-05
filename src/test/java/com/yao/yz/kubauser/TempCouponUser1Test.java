package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUser1;
import com.yao.yz.kubauser.persistence.dao.TempCouponUser1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUser1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUser1.class);
	@Autowired
	private TempCouponUser1Dao dao;

	private void setObjVal(TempCouponUser1 sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUser1 objInsert = new TempCouponUser1();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUser1]");
		dao.insert(objInsert);
		String key = "username";
		TempCouponUser1 objSelect = dao.getTempCouponUser1ByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUser1ByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUser1Test", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUser1Test", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUser1Test", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
