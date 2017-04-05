package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Tempusers;
import com.yao.yz.kubauser.persistence.dao.TempusersDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempusersTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Tempusers.class);
	@Autowired
	private TempusersDao dao;

	private void setObjVal(Tempusers sObj) {
		sObj.setUsername("username");
		sObj.setEmail("email");
	}

	@Test
	public void testCase() throws UnitTestException {
		Tempusers objInsert = new Tempusers();
		setObjVal(objInsert);

		LOGGER.info("+ [Tempusers]");
		dao.insert(objInsert);
		String key = "username";
		Tempusers objSelect = dao.getTempusersByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempusersByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempusersTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempusersTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempusersTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
