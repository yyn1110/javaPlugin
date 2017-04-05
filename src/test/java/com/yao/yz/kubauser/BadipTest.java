package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Badip;
import com.yao.yz.kubauser.persistence.dao.BadipDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BadipTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Badip.class);
	@Autowired
	private BadipDao dao;

	private void setObjVal(Badip sObj) {
		sObj.set登录ip("登录ip");
	}

	@Test
	public void testCase() throws UnitTestException {
		Badip objInsert = new Badip();
		setObjVal(objInsert);

		LOGGER.info("+ [Badip]");
		dao.insert(objInsert);
		String key = "登录ip";
		Badip objSelect = dao.getBadipByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getBadipByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("BadipTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("BadipTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("BadipTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
