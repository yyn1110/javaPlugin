package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinUserCoupon;
import com.yao.yz.kubauser.persistence.dao.WeixinUserCouponDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinUserCouponTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinUserCoupon.class);
	@Autowired
	private WeixinUserCouponDao dao;

	private void setObjVal(WeixinUserCoupon sObj) {
		sObj.setOpenId("openId");
		sObj.setUserId("userId");
		sObj.setBatchCode("batchCode");
		sObj.setGetTime(new java.util.Date());
		sObj.setShopId(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinUserCoupon objInsert = new WeixinUserCoupon();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinUserCoupon]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinUserCouponTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinUserCoupon objSelect = dao.getWeixinUserCouponByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinUserCouponTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinUserCouponTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinUserCouponTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
