package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerUseremail201007181141;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerUseremail201007181141Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerUseremail201007181141Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerUseremail201007181141.class);
	@Autowired
	private EcuserCustomerUseremail201007181141Dao dao;

	private void setObjVal(EcuserCustomerUseremail201007181141 sObj) {
		sObj.setEmail("email");
		sObj.setCon(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerUseremail201007181141 objInsert = new EcuserCustomerUseremail201007181141();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerUseremail201007181141]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
