package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczUser;
import com.yao.yz.kubauser.persistence.dao.WczUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczUser.class);
	@Autowired
	private WczUserDao dao;

	private void setObjVal(WczUser sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		WczUser objInsert = new WczUser();
		setObjVal(objInsert);

		LOGGER.info("+ [WczUser]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
