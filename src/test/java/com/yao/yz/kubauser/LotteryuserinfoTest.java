package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.Lotteryuserinfo;
import com.yao.yz.kubauser.persistence.dao.LotteryuserinfoDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LotteryuserinfoTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(Lotteryuserinfo.class);
	@Autowired
	private LotteryuserinfoDao dao;

	private void setObjVal(Lotteryuserinfo sObj) {
		sObj.setUserName("userName");
		sObj.setTel("tel");
		sObj.setUserId(1);
		sObj.setAddress("address");
		sObj.setRemark("remark");
		sObj.setActType(1);
		sObj.setIp("ip");
		sObj.setGoodsName("goodsName");
		sObj.setGoodsId(1);
		sObj.setRealName("realName");
	}

	@Test
	public void testCase() throws UnitTestException {
		Lotteryuserinfo objInsert = new Lotteryuserinfo();
		setObjVal(objInsert);

		LOGGER.info("+ [Lotteryuserinfo]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("LotteryuserinfoTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		Lotteryuserinfo objSelect = dao.getLotteryuserinfoByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("LotteryuserinfoTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("LotteryuserinfoTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("LotteryuserinfoTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
