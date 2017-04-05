package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.MSDelay;
import com.yao.yz.kubauser.persistence.dao.MSDelayDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MSDelayTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(MSDelay.class);
	@Autowired
	private MSDelayDao dao;

	private void setObjVal(MSDelay sObj) {
		sObj.setId(1);
		sObj.setTs(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		MSDelay objInsert = new MSDelay();
		setObjVal(objInsert);

		LOGGER.info("+ [MSDelay]");
		dao.insert(objInsert);
		Integer key = 1;
		MSDelay objSelect = dao.getMSDelayByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getMSDelayByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("MSDelayTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("MSDelayTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("MSDelayTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
