package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WeixinUserBind;
import com.yao.yz.kubauser.persistence.dao.WeixinUserBindDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeixinUserBindTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WeixinUserBind.class);
	@Autowired
	private WeixinUserBindDao dao;

	private void setObjVal(WeixinUserBind sObj) {
		sObj.setOpenId("openId");
		sObj.setUserId("userId");
		sObj.setBindDate(new java.util.Date());
		sObj.setStatus(1);
		sObj.setUnbindDate(new java.util.Date());
		sObj.setRecOpenId("recOpenId");
		sObj.setTaobaoAccount("taobaoAccount");
		sObj.setForwardLevel(1);
		sObj.setWeixinAccount("weixinAccount");
		sObj.setShopId(1);
		sObj.setVenderId("venderId");
	}

	@Test
	public void testCase() throws UnitTestException {
		WeixinUserBind objInsert = new WeixinUserBind();
		setObjVal(objInsert);

		LOGGER.info("+ [WeixinUserBind]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("WeixinUserBindTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		WeixinUserBind objSelect = dao.getWeixinUserBindByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("WeixinUserBindTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("WeixinUserBindTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("WeixinUserBindTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
