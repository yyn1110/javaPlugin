package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.ZsjVenderUser;
import com.yao.yz.kubauser.persistence.dao.ZsjVenderUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ZsjVenderUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(ZsjVenderUser.class);
	@Autowired
	private ZsjVenderUserDao dao;

	private void setObjVal(ZsjVenderUser sObj) {
		sObj.setVenderId("venderId");
		sObj.setUserName("userName");
		sObj.setMobile("mobile");
	}

	@Test
	public void testCase() throws UnitTestException {
		ZsjVenderUser objInsert = new ZsjVenderUser();
		setObjVal(objInsert);

		LOGGER.info("+ [ZsjVenderUser]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
