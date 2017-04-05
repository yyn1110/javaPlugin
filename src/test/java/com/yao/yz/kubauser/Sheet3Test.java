package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Sheet3;
import com.yao.yz.kubauser.persistence.dao.Sheet3Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Sheet3Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Sheet3.class);
	@Autowired
	private Sheet3Dao dao;

	private void setObjVal(Sheet3 sObj) {
		sObj.setF1("f1");
	}

	@Test
	public void testCase() throws UnitTestException {
		Sheet3 objInsert = new Sheet3();
		setObjVal(objInsert);

		LOGGER.info("+ [Sheet3]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
