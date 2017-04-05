package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.YdyVoucherLog;
import com.yao.yz.kubauser.persistence.dao.YdyVoucherLogDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class YdyVoucherLogTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(YdyVoucherLog.class);
	@Autowired
	private YdyVoucherLogDao dao;

	private void setObjVal(YdyVoucherLog sObj) {
		sObj.setCustomerId("customerId");
		sObj.setVoucherId("voucherId");
		sObj.setStatus(1);
		sObj.setRecipeCode("recipeCode");
		sObj.setRecipeUrl("recipeUrl");
		sObj.setCreatetime(new java.util.Date());
		sObj.setActivitytime(new java.util.Date());
		sObj.setClosetime(new java.util.Date());
		sObj.setOperaterId("operaterId");
		sObj.setOperaterName("operaterName");
	}

	@Test
	public void testCase() throws UnitTestException {
		YdyVoucherLog objInsert = new YdyVoucherLog();
		setObjVal(objInsert);

		LOGGER.info("+ [YdyVoucherLog]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("YdyVoucherLogTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		YdyVoucherLog objSelect = dao.getYdyVoucherLogByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("YdyVoucherLogTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("YdyVoucherLogTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("YdyVoucherLogTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
