package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcquyiShipto;
import com.yao.yz.kubauser.persistence.dao.EcquyiShiptoDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcquyiShiptoTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcquyiShipto.class);
	@Autowired
	private EcquyiShiptoDao dao;

	private void setObjVal(EcquyiShipto sObj) {
		sObj.setUserId("userId");
		sObj.setPerson("person");
		sObj.setContact("contact");
		sObj.setProvinceName("provinceName");
		sObj.setProvinceCode("provinceCode");
		sObj.setCityName("cityName");
		sObj.setCityCode("cityCode");
		sObj.setDistrictName("districtName");
		sObj.setDistrictCode("districtCode");
		sObj.setDetailAddress("detailAddress");
		sObj.setFullAddress("fullAddress");
		sObj.setCreateDate(new java.util.Date());
		sObj.setRemark("remark");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcquyiShipto objInsert = new EcquyiShipto();
		setObjVal(objInsert);

		LOGGER.info("+ [EcquyiShipto]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcquyiShiptoTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcquyiShipto objSelect = dao.getEcquyiShiptoByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcquyiShiptoTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcquyiShiptoTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcquyiShiptoTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
