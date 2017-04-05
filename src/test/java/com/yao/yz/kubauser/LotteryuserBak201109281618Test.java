package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.LotteryuserBak201109281618;
import com.yao.yz.kubauser.persistence.dao.LotteryuserBak201109281618Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LotteryuserBak201109281618Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(LotteryuserBak201109281618.class);
	@Autowired
	private LotteryuserBak201109281618Dao dao;

	private void setObjVal(LotteryuserBak201109281618 sObj) {
		sObj.setId(1);
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
		LotteryuserBak201109281618 objInsert = new LotteryuserBak201109281618();
		setObjVal(objInsert);

		LOGGER.info("+ [LotteryuserBak201109281618]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
