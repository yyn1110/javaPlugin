package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempVganenjie;
import com.yao.yz.kubauser.persistence.dao.TempVganenjieDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempVganenjieTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempVganenjie.class);
	@Autowired
	private TempVganenjieDao dao;

	private void setObjVal(TempVganenjie sObj) {
		sObj.setUsername("username");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempVganenjie objInsert = new TempVganenjie();
		setObjVal(objInsert);

		LOGGER.info("+ [TempVganenjie]");
		dao.insert(objInsert);
		String key = "username";
		TempVganenjie objSelect = dao.getTempVganenjieByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempVganenjieByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempVganenjieTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempVganenjieTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempVganenjieTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
