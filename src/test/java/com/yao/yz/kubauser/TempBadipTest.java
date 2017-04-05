package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempBadip;
import com.yao.yz.kubauser.persistence.dao.TempBadipDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempBadipTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempBadip.class);
	@Autowired
	private TempBadipDao dao;

	private void setObjVal(TempBadip sObj) {
		sObj.setIp("ip");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempBadip objInsert = new TempBadip();
		setObjVal(objInsert);

		LOGGER.info("+ [TempBadip]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
