package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCooperationuserBaidu2011101117;
import com.yao.yz.kubauser.persistence.dao.EcuserCooperationuserBaidu2011101117Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCooperationuserBaidu2011101117Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCooperationuserBaidu2011101117.class);
	@Autowired
	private EcuserCooperationuserBaidu2011101117Dao dao;

	private void setObjVal(EcuserCooperationuserBaidu2011101117 sObj) {
		sObj.setEcuserid(1);
		sObj.setId("id");
		sObj.setPartnerType(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCooperationuserBaidu2011101117 objInsert = new EcuserCooperationuserBaidu2011101117();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCooperationuserBaidu2011101117]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
