package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerRecord01;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerRecord01Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerRecord01Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerRecord01.class);
	@Autowired
	private EcuserCustomerRecord01Dao dao;

	private void setObjVal(EcuserCustomerRecord01 sObj) {
		sObj.setModifyDate(new java.util.Date());
		sObj.setModifyType(1);
		sObj.setModifyTypeName("modifyTypeName");
		sObj.setModifyBefore("modifyBefore");
		sObj.setModifyAfter("modifyAfter");
		sObj.setOperator("operator");
		sObj.setOperateIp("operateIp");
		sObj.setEcUserId(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerRecord01 objInsert = new EcuserCustomerRecord01();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerRecord01]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerRecord01Test", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerRecord01 objSelect = dao.getEcuserCustomerRecord01ByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerRecord01Test", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerRecord01Test", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerRecord01Test", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
