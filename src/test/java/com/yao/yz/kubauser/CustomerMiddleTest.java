package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.CustomerMiddle;
import com.yao.yz.kubauser.persistence.dao.CustomerMiddleDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerMiddleTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(CustomerMiddle.class);
	@Autowired
	private CustomerMiddleDao dao;

	private void setObjVal(CustomerMiddle sObj) {
		sObj.setEcuserid(1);
		sObj.setUserName("userName");
		sObj.setBackcount(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		CustomerMiddle objInsert = new CustomerMiddle();
		setObjVal(objInsert);

		LOGGER.info("+ [CustomerMiddle]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
