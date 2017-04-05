package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TmpRegtime;
import com.yao.yz.kubauser.persistence.dao.TmpRegtimeDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TmpRegtimeTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TmpRegtime.class);
	@Autowired
	private TmpRegtimeDao dao;

	private void setObjVal(TmpRegtime sObj) {
		sObj.setId("id");
		sObj.setName("name");
		sObj.setTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		TmpRegtime objInsert = new TmpRegtime();
		setObjVal(objInsert);

		LOGGER.info("+ [TmpRegtime]");
		dao.insert(objInsert);
		String key = "name";
		TmpRegtime objSelect = dao.getTmpRegtimeByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getTmpRegtimeByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("TmpRegtimeTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("TmpRegtimeTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("TmpRegtimeTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
