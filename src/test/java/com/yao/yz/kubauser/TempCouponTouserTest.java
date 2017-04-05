package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponTouser;
import com.yao.yz.kubauser.persistence.dao.TempCouponTouserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponTouserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponTouser.class);
	@Autowired
	private TempCouponTouserDao dao;

	private void setObjVal(TempCouponTouser sObj) {
		sObj.setUsername("username");
		sObj.setBatchcode("batchcode");
		sObj.setActivedate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponTouser objInsert = new TempCouponTouser();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponTouser]");
		dao.insert(objInsert);
		String key = "username";
		TempCouponTouser objSelect = dao.getTempCouponTouserByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponTouserByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponTouserTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponTouserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponTouserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
