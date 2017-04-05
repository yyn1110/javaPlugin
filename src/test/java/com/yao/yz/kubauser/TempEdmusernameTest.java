package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempEdmusername;
import com.yao.yz.kubauser.persistence.dao.TempEdmusernameDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempEdmusernameTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempEdmusername.class);
	@Autowired
	private TempEdmusernameDao dao;

	private void setObjVal(TempEdmusername sObj) {
		sObj.setId("id");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempEdmusername objInsert = new TempEdmusername();
		setObjVal(objInsert);

		LOGGER.info("+ [TempEdmusername]");
		dao.insert(objInsert);
		String key = "id";
		TempEdmusername objSelect = dao.getTempEdmusernameByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempEdmusernameByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempEdmusernameTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempEdmusernameTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempEdmusernameTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
