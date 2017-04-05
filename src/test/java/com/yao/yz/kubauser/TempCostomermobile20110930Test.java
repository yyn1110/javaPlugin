package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.TempCostomermobile20110930;
import com.yao.yz.kubauser.persistence.dao.TempCostomermobile20110930Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCostomermobile20110930Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(TempCostomermobile20110930.class);
	@Autowired
	private TempCostomermobile20110930Dao dao;

	private void setObjVal(TempCostomermobile20110930 sObj) {
		sObj.setId("id");
		sObj.setCellphone("cellphone");
	}

	@Test
	public void testCase() throws UnitTestException {
		TempCostomermobile20110930 objInsert = new TempCostomermobile20110930();
		setObjVal(objInsert);

		LOGGER.info("+ [TempCostomermobile20110930]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
