package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserUpdateuserauthinfologs;
import com.yao.yz.kubauser.persistence.dao.EcuserUpdateuserauthinfologsDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserUpdateuserauthinfologsTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserUpdateuserauthinfologs.class);
	@Autowired
	private EcuserUpdateuserauthinfologsDao dao;

	private void setObjVal(EcuserUpdateuserauthinfologs sObj) {
		sObj.setOperator("operator");
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setType(1);
		sObj.setDate(new java.util.Date());
		sObj.setContent("content");
		sObj.setUserLoginEmail("userLoginEmail");
		sObj.setUserLoginMobile("userLoginMobile");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserUpdateuserauthinfologs objInsert = new EcuserUpdateuserauthinfologs();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserUpdateuserauthinfologs]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserUpdateuserauthinfologsTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserUpdateuserauthinfologs objSelect = dao.getEcuserUpdateuserauthinfologsByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserUpdateuserauthinfologsTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserUpdateuserauthinfologsTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserUpdateuserauthinfologsTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
