package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCustomer20111021;
import com.yao.yz.kubauser.persistence.dao.TempCustomer20111021Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCustomer20111021Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCustomer20111021.class);
	@Autowired
	private TempCustomer20111021Dao dao;

	private void setObjVal(TempCustomer20111021 sObj) {
		sObj.setEcUserId(1);
		sObj.setId("id");
		sObj.setRegisterIP("registerIP");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCustomer20111021 objInsert = new TempCustomer20111021();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCustomer20111021]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
