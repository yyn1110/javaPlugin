package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempEdmEmail;
import com.yao.yz.kubauser.persistence.dao.TempEdmEmailDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempEdmEmailTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempEdmEmail.class);
	@Autowired
	private TempEdmEmailDao dao;

	private void setObjVal(TempEdmEmail sObj) {
		sObj.setEmailAddress("emailAddress");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempEdmEmail objInsert = new TempEdmEmail();
		setObjVal(objInsert);

		LOGGER.info("+ [TempEdmEmail]");
		dao.insert(objInsert);
		String key = "emailAddress";
		TempEdmEmail objSelect = dao.getTempEdmEmailByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempEdmEmailByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempEdmEmailTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempEdmEmailTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempEdmEmailTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
