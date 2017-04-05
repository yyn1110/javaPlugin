package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcUnableUseremail;
import com.yao.yz.kubauser.persistence.dao.EcUnableUseremailDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcUnableUseremailTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcUnableUseremail.class);
	@Autowired
	private EcUnableUseremailDao dao;

	private void setObjVal(EcUnableUseremail sObj) {
		sObj.setEmail("email");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcUnableUseremail objInsert = new EcUnableUseremail();
		setObjVal(objInsert);

		LOGGER.info("+ [EcUnableUseremail]");
		dao.insert(objInsert);
		String key = "email";
		EcUnableUseremail objSelect = dao.getEcUnableUseremailByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcUnableUseremailByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcUnableUseremailTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcUnableUseremailTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcUnableUseremailTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
