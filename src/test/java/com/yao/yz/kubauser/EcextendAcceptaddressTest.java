package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcextendAcceptaddress;
import com.yao.yz.kubauser.persistence.dao.EcextendAcceptaddressDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcextendAcceptaddressTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcextendAcceptaddress.class);
	@Autowired
	private EcextendAcceptaddressDao dao;

	private void setObjVal(EcextendAcceptaddress sObj) {
		sObj.setUserId(1);
		sObj.setUsername("username");
		sObj.setRealName("realName");
		sObj.setPostCode("postCode");
		sObj.setAddress("address");
		sObj.setTel("tel");
		sObj.setMobile("mobile");
		sObj.setProvince("province");
		sObj.setCity("city");
		sObj.setCounty("county");
		sObj.setEmail("email");
		sObj.setInvoiceTitle("invoiceTitle");
		sObj.setShowOrder(1);
		sObj.setSiteId("siteId");
		sObj.setProvinceName("provinceName");
		sObj.setCityName("cityName");
		sObj.setCountyName("countyName");
		sObj.setProvinceNo(1);
		sObj.setCityNo(1);
		sObj.setCountyNo(1);
		sObj.setShipAreaNo(1);
		sObj.setShipArea("shipArea");
		sObj.setTelCityCode("telCityCode");
		sObj.setTelExtNumber("telExtNumber");
		sObj.setNearByBuilding("nearByBuilding");
		sObj.setIsDefault(1);
		sObj.setQuickOrderName("quickOrderName");
		sObj.setDeliverType("deliverType");
		sObj.setPayBankName("payBankName");
		sObj.setInvoiceType(1);
		sObj.setPayType(1);
		sObj.setInvoiceInfo("invoiceInfo");
		sObj.setAddressType(1);
		sObj.setIsDefaultOfQuickOrderInfo(1);
		sObj.setIsLastAddress(1);
		sObj.setLastUseTime(new java.util.Date());
		sObj.setPayBankCode("payBankCod");
		sObj.setPayBankUrl("payBankUrl");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcextendAcceptaddress objInsert = new EcextendAcceptaddress();
		setObjVal(objInsert);

		LOGGER.info("+ [EcextendAcceptaddress]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcextendAcceptaddressTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcextendAcceptaddress objSelect = dao.getEcextendAcceptaddressByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcextendAcceptaddressTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcextendAcceptaddressTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcextendAcceptaddressTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
