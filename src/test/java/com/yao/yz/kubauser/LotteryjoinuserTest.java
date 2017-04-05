package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Lotteryjoinuser;
import com.yao.yz.kubauser.persistence.dao.LotteryjoinuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LotteryjoinuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Lotteryjoinuser.class);
	@Autowired
	private LotteryjoinuserDao dao;

	private void setObjVal(Lotteryjoinuser sObj) {
		sObj.setUserName("userName");
		sObj.setIp("ip");
		sObj.setClickCount(1);
		sObj.setJoinTime(new java.util.Date());
		sObj.setUserId(1);
		sObj.setJoinDate(new java.util.Date());
		sObj.setActType(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		Lotteryjoinuser objInsert = new Lotteryjoinuser();
		setObjVal(objInsert);

		LOGGER.info("+ [Lotteryjoinuser]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("LotteryjoinuserTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		Lotteryjoinuser objSelect = dao.getLotteryjoinuserByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("LotteryjoinuserTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("LotteryjoinuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("LotteryjoinuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
