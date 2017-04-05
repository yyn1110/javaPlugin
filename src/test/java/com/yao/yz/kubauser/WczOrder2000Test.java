package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.WczOrder2000;
import com.yao.yz.kubauser.persistence.dao.WczOrder2000Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WczOrder2000Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(WczOrder2000.class);
	@Autowired
	private WczOrder2000Dao dao;

	private void setObjVal(WczOrder2000 sObj) {
		sObj.set用户名("用户名");
		sObj.set真实姓名("真实姓名");
		sObj.set手机("手机");
		sObj.set省("省");
		sObj.set市("市");
		sObj.set区("区");
		sObj.set下单时间(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		WczOrder2000 objInsert = new WczOrder2000();
		setObjVal(objInsert);

		LOGGER.info("+ [WczOrder2000]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
