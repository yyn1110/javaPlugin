package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUsernameSumCopy;
import com.yao.yz.kubauser.persistence.dao.TempCouponUsernameSumCopyDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUsernameSumCopyTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUsernameSumCopy.class);
	@Autowired
	private TempCouponUsernameSumCopyDao dao;

	private void setObjVal(TempCouponUsernameSumCopy sObj) {
		sObj.setUsername("username");
		sObj.setDenomination(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUsernameSumCopy objInsert = new TempCouponUsernameSumCopy();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUsernameSumCopy]");
		dao.insert(objInsert);
		String key = "username";
		TempCouponUsernameSumCopy objSelect = dao.getTempCouponUsernameSumCopyByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUsernameSumCopyByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUsernameSumCopyTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUsernameSumCopyTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUsernameSumCopyTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
