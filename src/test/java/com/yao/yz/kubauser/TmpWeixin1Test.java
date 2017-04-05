package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TmpWeixin1;
import com.yao.yz.kubauser.persistence.dao.TmpWeixin1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TmpWeixin1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TmpWeixin1.class);
	@Autowired
	private TmpWeixin1Dao dao;

	private void setObjVal(TmpWeixin1 sObj) {
		sObj.setUserId("userId");
		sObj.setId("id");
		sObj.setEmail("email");
		sObj.setLoginEmail("loginEmail");
	}

	@Test
	public void testCase() throws UnitTestException {
		TmpWeixin1 objInsert = new TmpWeixin1();
		setObjVal(objInsert);

		LOGGER.info("+ [TmpWeixin1]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
