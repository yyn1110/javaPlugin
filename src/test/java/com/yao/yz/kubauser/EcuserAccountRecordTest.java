package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserAccountRecord;
import com.yao.yz.kubauser.persistence.dao.EcuserAccountRecordDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserAccountRecordTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserAccountRecord.class);
	@Autowired
	private EcuserAccountRecordDao dao;

	private void setObjVal(EcuserAccountRecord sObj) {
		sObj.setAccountId(1);
		sObj.setChangeDate(new java.util.Date());
		sObj.setAcountChange(1.0);
		sObj.setBackCountChange(1.0);
		sObj.setOrderId("orderId");
		sObj.setRemark("remark");
		sObj.setOperator("operator");
		sObj.setTypeName("typeName");
		sObj.setTypeId(1);
		sObj.setEcuserId(1);
		sObj.setStatus(1);
		sObj.setApplyTime(new java.util.Date());
		sObj.setFinishTime(new java.util.Date());
		sObj.setCancelTime(new java.util.Date());
		sObj.setCheckDate(new java.util.Date());
		sObj.setFreeAccountChange(1.0);
		sObj.setFreeBackCountChange(1.0);
		sObj.setProviceId(1);
		sObj.setCityId(1);
		sObj.setProviceName("proviceName");
		sObj.setCityName("cityName");
		sObj.setBankAccount("bankAccount");
		sObj.setBankName("bankName");
		sObj.setCartHolder("cartHolder");
		sObj.setRefundType(1);
		sObj.setAlipayAccount("alipayAccount");
		sObj.setApplyTypeId(1);
		sObj.setUserName("userName");
		sObj.setOrderSplitDate(new java.util.Date());
		sObj.setOrderPayDate(new java.util.Date());
		sObj.setRefundOrderId("refundOrderId");
		sObj.setNetMode(1);
		sObj.setOrderOrigin(1);
		sObj.setExternalOrder("externalOrder");
		sObj.setOutPayNumber("outPayNumber");
		sObj.setCheckOperator("checkOperator");
		sObj.setPayMethod(1);
		sObj.setFailReson(1);
		sObj.setNeedCheck(1);
		sObj.setBeforeAccount(1.0);
		sObj.setAfterAccount(1.0);
		sObj.setBeforeBackCount(1.0);
		sObj.setAfterBackCount(1.0);
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserAccountRecord objInsert = new EcuserAccountRecord();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserAccountRecord]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserAccountRecordTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserAccountRecord objSelect = dao.getEcuserAccountRecordByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserAccountRecordTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserAccountRecordTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserAccountRecordTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
