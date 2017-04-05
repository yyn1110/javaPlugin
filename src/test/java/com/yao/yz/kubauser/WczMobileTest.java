package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczMobile;
import com.yao.yz.kubauser.persistence.dao.WczMobileDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczMobileTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczMobile.class);
	@Autowired
	private WczMobileDao dao;

	private void setObjVal(WczMobile sObj) {
		sObj.setUsername("username");
		sObj.setSendContactmobile("sendContactmobile");
	}

	@Test
	public void testCase() throws UnitTestException {
		WczMobile objInsert = new WczMobile();
		setObjVal(objInsert);

		LOGGER.info("+ [WczMobile]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
