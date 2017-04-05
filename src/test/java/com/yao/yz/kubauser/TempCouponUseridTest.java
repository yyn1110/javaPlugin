package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserid;
import com.yao.yz.kubauser.persistence.dao.TempCouponUseridDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUseridTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserid.class);
	@Autowired
	private TempCouponUseridDao dao;

	private void setObjVal(TempCouponUserid sObj) {
		sObj.setUserid("userid");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserid objInsert = new TempCouponUserid();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserid]");
		dao.insert(objInsert);
		String key = "userid";
		TempCouponUserid objSelect = dao.getTempCouponUseridByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUseridByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUseridTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUseridTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUseridTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
