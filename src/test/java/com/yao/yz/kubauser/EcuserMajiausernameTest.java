package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserMajiausername;
import com.yao.yz.kubauser.persistence.dao.EcuserMajiausernameDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserMajiausernameTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserMajiausername.class);
	@Autowired
	private EcuserMajiausernameDao dao;

	private void setObjVal(EcuserMajiausername sObj) {
		sObj.setMajianame("majianame");
		sObj.setType(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserMajiausername objInsert = new EcuserMajiausername();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserMajiausername]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserMajiausernameTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserMajiausername objSelect = dao.getEcuserMajiausernameByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserMajiausernameTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserMajiausernameTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserMajiausernameTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
