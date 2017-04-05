package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserTelephone1;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserTelephone1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserTelephone1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserTelephone1.class);
	@Autowired
	private TempCouponUserTelephone1Dao dao;

	private void setObjVal(TempCouponUserTelephone1 sObj) {
		sObj.setTelephone("telephone");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserTelephone1 objInsert = new TempCouponUserTelephone1();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserTelephone1]");
		dao.insert(objInsert);
		String key = "telephone";
		TempCouponUserTelephone1 objSelect = dao.getTempCouponUserTelephone1ByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUserTelephone1ByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUserTelephone1Test", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUserTelephone1Test", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUserTelephone1Test", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
