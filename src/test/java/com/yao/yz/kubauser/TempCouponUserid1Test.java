package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserid1;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserid1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserid1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserid1.class);
	@Autowired
	private TempCouponUserid1Dao dao;

	private void setObjVal(TempCouponUserid1 sObj) {
		sObj.setUserid(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserid1 objInsert = new TempCouponUserid1();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserid1]");
		dao.insert(objInsert);
		Integer key = 1;
		TempCouponUserid1 objSelect = dao.getTempCouponUserid1ByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUserid1ByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUserid1Test", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUserid1Test", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUserid1Test", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
