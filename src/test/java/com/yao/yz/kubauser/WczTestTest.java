package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczTest;
import com.yao.yz.kubauser.persistence.dao.WczTestDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczTestTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczTest.class);
	@Autowired
	private WczTestDao dao;

	private void setObjVal(WczTest sObj) {
		sObj.setOrderid("orderid");
		sObj.setUsername("username");
		sObj.setOrderdate(new java.util.Date());
		sObj.setOrderfinishtime(new java.util.Date());
		sObj.setTheallmoney(new java.math.BigDecimal(1.0));
		sObj.setCatname("catname");
		sObj.setGoodsname("goodsname");
		sObj.setProductscore(1);
		sObj.setOrderScore(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WczTest objInsert = new WczTest();
		setObjVal(objInsert);

		LOGGER.info("+ [WczTest]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
