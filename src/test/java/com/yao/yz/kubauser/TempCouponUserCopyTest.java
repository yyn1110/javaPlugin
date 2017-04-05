package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCouponUserCopy;
import com.yao.yz.kubauser.persistence.dao.TempCouponUserCopyDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCouponUserCopyTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCouponUserCopy.class);
	@Autowired
	private TempCouponUserCopyDao dao;

	private void setObjVal(TempCouponUserCopy sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCouponUserCopy objInsert = new TempCouponUserCopy();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCouponUserCopy]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
