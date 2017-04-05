package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.OpenVenderUser;
import com.yao.yz.kubauser.persistence.dao.OpenVenderUserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OpenVenderUserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(OpenVenderUser.class);
	@Autowired
	private OpenVenderUserDao dao;

	private void setObjVal(OpenVenderUser sObj) {
		sObj.setVenderId("venderId");
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setType(1);
		sObj.setStatus(1);
		sObj.setMobile("mobile");
		sObj.setInputer("inputer");
		sObj.setInputTime(new java.util.Date());
		sObj.setUpdater("updater");
		sObj.setUpdateTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		OpenVenderUser objInsert = new OpenVenderUser();
		setObjVal(objInsert);

		LOGGER.info("+ [OpenVenderUser]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("OpenVenderUserTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		OpenVenderUser objSelect = dao.getOpenVenderUserByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("OpenVenderUserTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("OpenVenderUserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("OpenVenderUserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
