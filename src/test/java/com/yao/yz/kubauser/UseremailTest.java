package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Useremail;
import com.yao.yz.kubauser.persistence.dao.UseremailDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UseremailTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Useremail.class);
	@Autowired
	private UseremailDao dao;

	private void setObjVal(Useremail sObj) {
		sObj.setEmail("email");
	}

	@Test
	public void testCase() throws UnitTestException {
		Useremail objInsert = new Useremail();
		setObjVal(objInsert);

		LOGGER.info("+ [Useremail]");
		dao.insert(objInsert);
		String key = "email";
		Useremail objSelect = dao.getUseremailByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getUseremailByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("UseremailTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("UseremailTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("UseremailTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
