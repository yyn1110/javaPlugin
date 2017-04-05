package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.YdyRecipeLog;
import com.yao.yz.kubauser.persistence.dao.YdyRecipeLogDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class YdyRecipeLogTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(YdyRecipeLog.class);
	@Autowired
	private YdyRecipeLogDao dao;

	private void setObjVal(YdyRecipeLog sObj) {
		sObj.setVoucherId("voucherId");
		sObj.setRecipeId("recipeId");
		sObj.setRecipeUrl("recipeUrl");
		sObj.setCreatetime(new java.util.Date());
		sObj.setCallBack(1);
		sObj.setOrderNo("orderNo");
		sObj.setIsDel(1);
		sObj.setOperaterId("operaterId");
		sObj.setOperaterName("operaterName");
	}

	@Test
	public void testCase() throws UnitTestException {
		YdyRecipeLog objInsert = new YdyRecipeLog();
		setObjVal(objInsert);

		LOGGER.info("+ [YdyRecipeLog]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("YdyRecipeLogTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		YdyRecipeLog objSelect = dao.getYdyRecipeLogByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("YdyRecipeLogTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("YdyRecipeLogTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("YdyRecipeLogTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
