package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Lotteryuser;
import com.yao.yz.kubauser.persistence.dao.LotteryuserDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LotteryuserTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Lotteryuser.class);
	@Autowired
	private LotteryuserDao dao;

	private void setObjVal(Lotteryuser sObj) {
		sObj.setUserName("userName");
		sObj.setUserId(1);
		sObj.setGoodsName("goodsName");
		sObj.setGoodsId("goodsId");
		sObj.setLotteryTime(new java.util.Date());
		sObj.setIp("ip");
		sObj.setActType(1);
		sObj.setLotteryDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		Lotteryuser objInsert = new Lotteryuser();
		setObjVal(objInsert);

		LOGGER.info("+ [Lotteryuser]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("LotteryuserTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		Lotteryuser objSelect = dao.getLotteryuserByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("LotteryuserTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("LotteryuserTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("LotteryuserTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
