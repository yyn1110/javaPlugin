package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczUserlevescore;
import com.yao.yz.kubauser.persistence.dao.WczUserlevescoreDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczUserlevescoreTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczUserlevescore.class);
	@Autowired
	private WczUserlevescoreDao dao;

	private void setObjVal(WczUserlevescore sObj) {
		sObj.setId("id");
		sObj.setUserlevelid(1);
		sObj.setUserscore(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WczUserlevescore objInsert = new WczUserlevescore();
		setObjVal(objInsert);

		LOGGER.info("+ [WczUserlevescore]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
