package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempBaduserid;
import com.yao.yz.kubauser.persistence.dao.TempBaduseridDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempBaduseridTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempBaduserid.class);
	@Autowired
	private TempBaduseridDao dao;

	private void setObjVal(TempBaduserid sObj) {
		sObj.setUserid(1);
		sObj.set会员级别("会�");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempBaduserid objInsert = new TempBaduserid();
		setObjVal(objInsert);

		LOGGER.info("+ [TempBaduserid]");
		dao.insert(objInsert);
		Integer key = 1;
		TempBaduserid objSelect = dao.getTempBaduseridByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTempBaduseridByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TempBaduseridTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TempBaduseridTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TempBaduseridTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
