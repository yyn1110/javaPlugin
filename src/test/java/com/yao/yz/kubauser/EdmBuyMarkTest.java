package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EdmBuyMark;
import com.yao.yz.kubauser.persistence.dao.EdmBuyMarkDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EdmBuyMarkTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EdmBuyMark.class);
	@Autowired
	private EdmBuyMarkDao dao;

	private void setObjVal(EdmBuyMark sObj) {
		sObj.setUserid(1);
		sObj.setOrderdate("orderdate");
	}

	@Test
	public void testCase() throws UnitTestException {
		EdmBuyMark objInsert = new EdmBuyMark();
		setObjVal(objInsert);

		LOGGER.info("+ [EdmBuyMark]");
		dao.insert(objInsert);
		Integer key = 1;
		EdmBuyMark objSelect = dao.getEdmBuyMarkByKey(key);
		if (objSelect == null) {
			dao.insert(objInsert);
			LOGGER.info("	insert OK");

			objSelect = dao.getEdmBuyMarkByKey(key);
			if (objSelect == null) {
			throw new UnitTestException("EdmBuyMarkTest", "test of select is failed");
			}
			LOGGER.info("	select OK");

		}
		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EdmBuyMarkTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EdmBuyMarkTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
