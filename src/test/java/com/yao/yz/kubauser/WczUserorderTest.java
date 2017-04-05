package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczUserorder;
import com.yao.yz.kubauser.persistence.dao.WczUserorderDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczUserorderTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczUserorder.class);
	@Autowired
	private WczUserorderDao dao;

	private void setObjVal(WczUserorder sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		WczUserorder objInsert = new WczUserorder();
		setObjVal(objInsert);

		LOGGER.info("+ [WczUserorder]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
