package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserTelephone;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserTelephoneDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserTelephoneTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserTelephone.class);
	@Autowired
	private TempCouponUserTelephoneDao dao;

	private void setObjVal(TempCouponUserTelephone sObj) {
		sObj.setTelephone("telephone");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserTelephone objInsert = new TempCouponUserTelephone();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserTelephone]");
		dao.insert(objInsert);
		String key = "telephone";
		TempCouponUserTelephone objSelect = dao.getTempCouponUserTelephoneByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempCouponUserTelephoneByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempCouponUserTelephoneTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempCouponUserTelephoneTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempCouponUserTelephoneTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
