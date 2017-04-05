package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczUserlogincount;
import com.yao.yz.kubauser.persistence.dao.WczUserlogincountDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczUserlogincountTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczUserlogincount.class);
	@Autowired
	private WczUserlogincountDao dao;

	private void setObjVal(WczUserlogincount sObj) {
		sObj.setUserid(1.0);
		sObj.setC(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		WczUserlogincount objInsert = new WczUserlogincount();
		setObjVal(objInsert);

		LOGGER.info("+ [WczUserlogincount]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
