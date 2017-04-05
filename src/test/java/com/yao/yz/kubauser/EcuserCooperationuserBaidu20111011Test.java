package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserBaidu20111011;
import com.yao.yz.kubauser.persistence.dao.EcuserCooperationuserBaidu20111011Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCooperationuserBaidu20111011Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCooperationuserBaidu20111011.class);
	@Autowired
	private EcuserCooperationuserBaidu20111011Dao dao;

	private void setObjVal(EcuserCooperationuserBaidu20111011 sObj) {
		sObj.setEcuserid(1);
		sObj.setId("id");
		sObj.setPartnerType(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCooperationuserBaidu20111011 objInsert = new EcuserCooperationuserBaidu20111011();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCooperationuserBaidu20111011]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
