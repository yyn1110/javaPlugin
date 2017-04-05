package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.XyyTempUser;
import com.yao.yz.kubauser.persistence.dao.XyyTempUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class XyyTempUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(XyyTempUser.class);
	@Autowired
	private XyyTempUserDao dao;

	private void setObjVal(XyyTempUser sObj) {
		sObj.setUserName("userName");
		sObj.setScore(1);
		sObj.setSyscomment("syscomment");
	}

	@Test
	public void testCase() throws UnitTestException {
		XyyTempUser objInsert = new XyyTempUser();
		setObjVal(objInsert);

		LOGGER.info("+ [XyyTempUser]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
