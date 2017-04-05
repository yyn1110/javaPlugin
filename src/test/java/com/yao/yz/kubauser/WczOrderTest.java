package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczOrder;
import com.yao.yz.kubauser.persistence.dao.WczOrderDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczOrderTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczOrder.class);
	@Autowired
	private WczOrderDao dao;

	private void setObjVal(WczOrder sObj) {
		sObj.setOrderid("orderid");
		sObj.setOrderdate(new java.util.Date());
		sObj.setTheallmoney(new java.math.BigDecimal(1.0));
		sObj.setProductcount(1.0);
		sObj.setGoodsname("goodsname");
		sObj.setCatname("catname");
		sObj.setUsername("username");
		sObj.setPaymethodname("paymethodname");
	}

	@Test
	public void testCase() throws UnitTestException {
		WczOrder objInsert = new WczOrder();
		setObjVal(objInsert);

		LOGGER.info("+ [WczOrder]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
