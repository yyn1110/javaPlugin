package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.YdyVoucher;
import com.yao.yz.kubauser.persistence.dao.YdyVoucherDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class YdyVoucherTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(YdyVoucher.class);
	@Autowired
	private YdyVoucherDao dao;

	private void setObjVal(YdyVoucher sObj) {
		sObj.setVoucherId("voucherId");
		sObj.setStatus(1);
		sObj.setCreatetime(new java.util.Date());
		sObj.setActiveTime(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		YdyVoucher objInsert = new YdyVoucher();
		setObjVal(objInsert);

		LOGGER.info("+ [YdyVoucher]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("YdyVoucherTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		YdyVoucher objSelect = dao.getYdyVoucherByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("YdyVoucherTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("YdyVoucherTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("YdyVoucherTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
