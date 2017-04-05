package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserUserid;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserUseridDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserUseridTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserUserid.class);
	@Autowired
	private TempCouponUserUseridDao dao;

	private void setObjVal(TempCouponUserUserid sObj) {
		sObj.setNo(1);
		sObj.setUserId(1);
		sObj.setUsername1("username1");
		sObj.setTelephone("telephone");
		sObj.setEmail("email");
		sObj.setUsername2("username2");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserUserid objInsert = new TempCouponUserUserid();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserUserid]");
		dao.insert(objInsert);
		Integer key = 1;
		TempCouponUserUserid objSelect = dao.getTempCouponUserUseridByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUserUseridByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUserUseridTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUserUseridTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUserUseridTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
