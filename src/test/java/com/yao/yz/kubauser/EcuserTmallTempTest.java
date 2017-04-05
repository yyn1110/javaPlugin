package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserTmallTemp;
import com.yao.yz.kubauser.persistence.dao.EcuserTmallTempDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserTmallTempTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserTmallTemp.class);
	@Autowired
	private EcuserTmallTempDao dao;

	private void setObjVal(EcuserTmallTemp sObj) {
		sObj.setEcuserid(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserTmallTemp objInsert = new EcuserTmallTemp();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserTmallTemp]");
		dao.insert(objInsert);
		Integer key = 1;
		EcuserTmallTemp objSelect = dao.getEcuserTmallTempByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEcuserTmallTempByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EcuserTmallTempTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserTmallTempTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserTmallTempTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
