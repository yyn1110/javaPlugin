package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczScoreusername;
import com.yao.yz.kubauser.persistence.dao.WczScoreusernameDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczScoreusernameTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczScoreusername.class);
	@Autowired
	private WczScoreusernameDao dao;

	private void setObjVal(WczScoreusername sObj) {
		sObj.setScore(1);
		sObj.setUsername("username");
		sObj.setDatetime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		WczScoreusername objInsert = new WczScoreusername();
		setObjVal(objInsert);

		LOGGER.info("+ [WczScoreusername]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
