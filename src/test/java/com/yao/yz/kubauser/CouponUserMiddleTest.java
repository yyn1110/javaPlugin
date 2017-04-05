package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.CouponUserMiddle;
import com.yao.yz.kubauser.persistence.dao.CouponUserMiddleDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponUserMiddleTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(CouponUserMiddle.class);
	@Autowired
	private CouponUserMiddleDao dao;

	private void setObjVal(CouponUserMiddle sObj) {
		sObj.setBatchcode("batchcode");
		sObj.setCode("code");
		sObj.setUsername("username");
		sObj.setSenddate(new java.util.Date());
		sObj.setStatus(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		CouponUserMiddle objInsert = new CouponUserMiddle();
		setObjVal(objInsert);

		LOGGER.info("+ [CouponUserMiddle]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
