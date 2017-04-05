package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczScoreusernameRegister;
import com.yao.yz.kubauser.persistence.dao.WczScoreusernameRegisterDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczScoreusernameRegisterTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczScoreusernameRegister.class);
	@Autowired
	private WczScoreusernameRegisterDao dao;

	private void setObjVal(WczScoreusernameRegister sObj) {
		sObj.setScore(1);
		sObj.setUsername("username");
		sObj.setDatetime(new java.util.Date());
		sObj.setCreatedate(new java.util.Date());
		sObj.setRegisterip("registerip");
		sObj.setIsfei(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WczScoreusernameRegister objInsert = new WczScoreusernameRegister();
		setObjVal(objInsert);

		LOGGER.info("+ [WczScoreusernameRegister]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
