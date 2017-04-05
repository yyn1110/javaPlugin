package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczUsermobile;
import com.yao.yz.kubauser.persistence.dao.WczUsermobileDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczUsermobileTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczUsermobile.class);
	@Autowired
	private WczUsermobileDao dao;

	private void setObjVal(WczUsermobile sObj) {
		sObj.setUsername("username");
		sObj.setSendContactmobile("sendContactmobile");
	}

	@Test
	public void testCase() throws UnitTestException {
		WczUsermobile objInsert = new WczUsermobile();
		setObjVal(objInsert);

		LOGGER.info("+ [WczUsermobile]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
