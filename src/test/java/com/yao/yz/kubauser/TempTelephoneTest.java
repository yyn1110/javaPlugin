package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempTelephone;
import com.yao.yz.kubauser.persistence.dao.TempTelephoneDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempTelephoneTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempTelephone.class);
	@Autowired
	private TempTelephoneDao dao;

	private void setObjVal(TempTelephone sObj) {
		sObj.setTelephone("telephone");
		sObj.setCode("code");
		sObj.setActivecode("activecode");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempTelephone objInsert = new TempTelephone();
		setObjVal(objInsert);

		LOGGER.info("+ [TempTelephone]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
