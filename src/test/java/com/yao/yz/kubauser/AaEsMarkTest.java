package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.AaEsMark;
import com.yao.yz.kubauser.persistence.dao.AaEsMarkDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AaEsMarkTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(AaEsMark.class);
	@Autowired
	private AaEsMarkDao dao;

	private void setObjVal(AaEsMark sObj) {
		sObj.setUserid(1);
		sObj.setEdm(1);
		sObj.setSms(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		AaEsMark objInsert = new AaEsMark();
		setObjVal(objInsert);

		LOGGER.info("+ [AaEsMark]");
		dao.insert(objInsert);
		Integer key = 1;
		AaEsMark objSelect = dao.getAaEsMarkByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getAaEsMarkByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("AaEsMarkTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("AaEsMarkTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("AaEsMarkTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
