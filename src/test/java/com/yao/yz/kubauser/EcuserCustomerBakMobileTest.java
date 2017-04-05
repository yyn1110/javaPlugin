package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerBakMobile;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerBakMobileDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerBakMobileTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerBakMobile.class);
	@Autowired
	private EcuserCustomerBakMobileDao dao;

	private void setObjVal(EcuserCustomerBakMobile sObj) {
		sObj.setCellphone("cellphone");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerBakMobile objInsert = new EcuserCustomerBakMobile();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerBakMobile]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
