package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserQqtuanCoupon;
import com.yao.yz.kubauser.persistence.dao.EcuserQqtuanCouponDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserQqtuanCouponTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserQqtuanCoupon.class);
	@Autowired
	private EcuserQqtuanCouponDao dao;

	private void setObjVal(EcuserQqtuanCoupon sObj) {
		sObj.setUserId(1);
		sObj.setUserName("userName");
		sObj.setValidateCode("validateCode");
		sObj.setCouponCode("couponCode");
		sObj.setCreatedTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserQqtuanCoupon objInsert = new EcuserQqtuanCoupon();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserQqtuanCoupon]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserQqtuanCouponTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserQqtuanCoupon objSelect = dao.getEcuserQqtuanCouponByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserQqtuanCouponTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserQqtuanCouponTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserQqtuanCouponTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
