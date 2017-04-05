package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserSensitivewords;
import com.yao.yz.kubauser.persistence.dao.EcuserSensitivewordsDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserSensitivewordsTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserSensitivewords.class);
	@Autowired
	private EcuserSensitivewordsDao dao;

	private void setObjVal(EcuserSensitivewords sObj) {
		sObj.setWordContent("wordContent");
		sObj.setAddTime(new java.util.Date());
		sObj.setAddUser("addUser");
		sObj.setStatus(1);
		sObj.setType(1);
		sObj.setUpdateUser("updateUser");
		sObj.setUpdateTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserSensitivewords objInsert = new EcuserSensitivewords();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserSensitivewords]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserSensitivewordsTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserSensitivewords objSelect = dao.getEcuserSensitivewordsByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserSensitivewordsTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserSensitivewordsTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserSensitivewordsTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
