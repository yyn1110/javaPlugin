package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponIdUseridTelephone;
import com.yao.yz.kubauser.persistence.dao.TempCouponIdUseridTelephoneDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponIdUseridTelephoneTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponIdUseridTelephone.class);
	@Autowired
	private TempCouponIdUseridTelephoneDao dao;

	private void setObjVal(TempCouponIdUseridTelephone sObj) {
		sObj.setId(1);
		sObj.setUserid(1);
		sObj.setTelephone("telephone");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponIdUseridTelephone objInsert = new TempCouponIdUseridTelephone();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponIdUseridTelephone]");
		dao.insert(objInsert);
		Integer key = 1;
		TempCouponIdUseridTelephone objSelect = dao.getTempCouponIdUseridTelephoneByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponIdUseridTelephoneByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponIdUseridTelephoneTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponIdUseridTelephoneTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponIdUseridTelephoneTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
