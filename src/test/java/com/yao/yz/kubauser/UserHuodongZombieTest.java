package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.UserHuodongZombie;
import com.yao.yz.kubauser.persistence.dao.UserHuodongZombieDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserHuodongZombieTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(UserHuodongZombie.class);
	@Autowired
	private UserHuodongZombieDao dao;

	private void setObjVal(UserHuodongZombie sObj) {
		sObj.setId("id");
	}

	@Test
	public void testCase() throws UnitTestException {
		UserHuodongZombie objInsert = new UserHuodongZombie();
		setObjVal(objInsert);

		LOGGER.info("+ [UserHuodongZombie]");
		dao.insert(objInsert);
		String key = "id";
		UserHuodongZombie objSelect = dao.getUserHuodongZombieByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getUserHuodongZombieByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("UserHuodongZombieTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("UserHuodongZombieTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("UserHuodongZombieTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
