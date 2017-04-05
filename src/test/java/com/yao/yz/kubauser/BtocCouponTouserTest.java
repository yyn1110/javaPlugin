package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.BtocCouponTouser;
import com.yao.yz.kubauser.persistence.dao.BtocCouponTouserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BtocCouponTouserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(BtocCouponTouser.class);
	@Autowired
	private BtocCouponTouserDao dao;

	private void setObjVal(BtocCouponTouser sObj) {
		sObj.setCouponid(1);
		sObj.setBatchid(1);
		sObj.setBatchcode("batchcode");
		sObj.setCode("code");
		sObj.setActivecode("activecode");
		sObj.setUsername("username");
		sObj.setDenomination(1.0);
		sObj.setCostdeptid(1);
		sObj.setLimitprice(1.0);
		sObj.setStatus(1);
		sObj.setSendtype(1);
		sObj.setSendorderno("sendorderno");
		sObj.setBegindate(new java.util.Date());
		sObj.setEnddate(new java.util.Date());
		sObj.setSenddate(new java.util.Date());
		sObj.setActivadate(new java.util.Date());
		sObj.setUseorderno("useorderno");
		sObj.setUsedate(new java.util.Date());
		sObj.setIsautorefund(1);
		sObj.setRefunddate(new java.util.Date());
		sObj.setRefundorderno("refundorderno");
		sObj.setIsmainrefund(1);
		sObj.setIssplitrefund(1);
		sObj.setSplitisrefund(1);
		sObj.setSplitrefunddate(new java.util.Date());
		sObj.setErpsplitorderid("erpsplitorderid");
		sObj.setSplitredeemprice(1.0);
		sObj.setRedeemstatus(1);
		sObj.setSplitnewnumber("splitnewnumber");
		sObj.setRedeemlog("redeemlog");
		sObj.setIslimituse(1);
		sObj.setIslimituseinfo("islimituseinfo");
		sObj.setEffectivedays(1);
		sObj.setEffectivetype(1);
		sObj.setRemark("remark");
		sObj.setLogs("logs");
		sObj.setIsexpire(1);
		sObj.setCurrentTime(new java.util.Date());
		sObj.setItemid("itemid");
		sObj.setIsespecitem(1);
		sObj.setUselimitsay("uselimitsay");
		sObj.setJediscode(1);
	}

	@Test
	public void testCase() throws UnitTestException {
		BtocCouponTouser objInsert = new BtocCouponTouser();
		setObjVal(objInsert);

		LOGGER.info("+ [BtocCouponTouser]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("BtocCouponTouserTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		BtocCouponTouser objSelect = dao.getBtocCouponTouserByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("BtocCouponTouserTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("BtocCouponTouserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("BtocCouponTouserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
