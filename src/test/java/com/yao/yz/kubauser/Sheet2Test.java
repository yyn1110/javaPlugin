package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Sheet2;
import com.yao.yz.kubauser.persistence.dao.Sheet2Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Sheet2Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Sheet2.class);
	@Autowired
	private Sheet2Dao dao;

	private void setObjVal(Sheet2 sObj) {
		sObj.setF1("f1");
	}

	@Test
	public void testCase() throws UnitTestException {
		Sheet2 objInsert = new Sheet2();
		setObjVal(objInsert);

		LOGGER.info("+ [Sheet2]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
