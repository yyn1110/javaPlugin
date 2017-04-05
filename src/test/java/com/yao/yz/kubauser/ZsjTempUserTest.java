package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.ZsjTempUser;
import com.yao.yz.kubauser.persistence.dao.ZsjTempUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ZsjTempUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(ZsjTempUser.class);
	@Autowired
	private ZsjTempUserDao dao;

	private void setObjVal(ZsjTempUser sObj) {
		sObj.setUserName("userName");
		sObj.setScore(1);
		sObj.setSyscomment("syscomment");
	}

	@Test
	public void testCase() throws UnitTestException {
		ZsjTempUser objInsert = new ZsjTempUser();
		setObjVal(objInsert);

		LOGGER.info("+ [ZsjTempUser]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
