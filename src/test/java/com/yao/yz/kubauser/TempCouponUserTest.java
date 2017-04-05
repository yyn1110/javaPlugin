package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUser;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUser.class);
	@Autowired
	private TempCouponUserDao dao;

	private void setObjVal(TempCouponUser sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUser objInsert = new TempCouponUser();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUser]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
