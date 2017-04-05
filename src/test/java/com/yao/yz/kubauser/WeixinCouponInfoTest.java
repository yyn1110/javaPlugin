package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinCouponInfo;
import com.yao.yz.kubauser.persistence.dao.WeixinCouponInfoDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinCouponInfoTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinCouponInfo.class);
	@Autowired
	private WeixinCouponInfoDao dao;

	private void setObjVal(WeixinCouponInfo sObj) {
		sObj.setBatchCode("batchCode");
		sObj.setShowName("showName");
		sObj.setFreezeQuantity(1);
		sObj.setUsedCount(1);
		sObj.setInputeTime(new java.util.Date());
		sObj.setInputer("inputer");
		sObj.setStatus(1);
		sObj.setShopId(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinCouponInfo objInsert = new WeixinCouponInfo();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinCouponInfo]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinCouponInfoTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinCouponInfo objSelect = dao.getWeixinCouponInfoByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinCouponInfoTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinCouponInfoTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinCouponInfoTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
