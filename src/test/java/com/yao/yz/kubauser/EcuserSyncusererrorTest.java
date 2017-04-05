package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserSyncusererror;
import com.yao.yz.kubauser.persistence.dao.EcuserSyncusererrorDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserSyncusererrorTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserSyncusererror.class);
	@Autowired
	private EcuserSyncusererrorDao dao;

	private void setObjVal(EcuserSyncusererror sObj) {
		sObj.setSkey("skey");
		sObj.setStatus("s");
		sObj.setSType("sType");
		sObj.setSKind("sKind");
		sObj.setSDesc("sDesc");
		sObj.setAddDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserSyncusererror objInsert = new EcuserSyncusererror();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserSyncusererror]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserSyncusererrorTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserSyncusererror objSelect = dao.getEcuserSyncusererrorByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserSyncusererrorTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserSyncusererrorTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserSyncusererrorTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
