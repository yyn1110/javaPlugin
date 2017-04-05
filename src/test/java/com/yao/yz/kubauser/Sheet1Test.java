package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Sheet1;
import com.yao.yz.kubauser.persistence.dao.Sheet1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Sheet1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Sheet1.class);
	@Autowired
	private Sheet1Dao dao;

	private void setObjVal(Sheet1 sObj) {
		sObj.setF1("f1");
	}

	@Test
	public void testCase() throws UnitTestException {
		Sheet1 objInsert = new Sheet1();
		setObjVal(objInsert);

		LOGGER.info("+ [Sheet1]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
