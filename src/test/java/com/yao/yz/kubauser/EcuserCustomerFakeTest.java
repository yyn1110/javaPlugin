package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerFake;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerFakeDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerFakeTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerFake.class);
	@Autowired
	private EcuserCustomerFakeDao dao;

	private void setObjVal(EcuserCustomerFake sObj) {
		sObj.setEcUId(1);
		sObj.setLoginEmail("loginEmail");
		sObj.setLoginMobile("loginMobile");
		sObj.setId("id");
		sObj.setStatus(1);
		sObj.setCreateDate(new java.util.Date());
		sObj.setModifyDate(new java.util.Date());
		sObj.setName("name");
		sObj.setGender(1);
		sObj.setCellphone("cellphone");
		sObj.setTelephone("telephone");
		sObj.setOtherTel("otherTel");
		sObj.setFax("fax");
		sObj.setMsn("msn");
		sObj.setQq("qq");
		sObj.setAliww("aliww");
		sObj.setOtherIm("otherIm");
		sObj.setEmail("email");
		sObj.setMemo("memo");
		sObj.setState("state");
		sObj.setCity("city");
		sObj.setDistrict("district");
		sObj.setPostcode("postcode");
		sObj.setAddress("address");
		sObj.setIncome(1);
		sObj.setIsDeleted(1);
		sObj.setUserId("userId");
		sObj.setSource(1);
		sObj.setPassword("password");
		sObj.setSalt("salt");
		sObj.setUserscore(1);
		sObj.setEnterCount(1);
		sObj.setLastLoginTime(new java.util.Date());
		sObj.setRegisterIP("registerIP");
		sObj.setIpaddress("ipaddress");
		sObj.setType(1);
		sObj.setWebsiteSource("websiteSource");
		sObj.setTuanflags(1);
		sObj.setUserLevelId(1);
		sObj.setUserLevelStartTime(new java.util.Date());
		sObj.setUserLevelEndTime(new java.util.Date());
		sObj.setBirthDay(new java.util.Date());
		sObj.setNickName("nickName");
		sObj.setImgUrl("imgUrl");
		sObj.setYearOrderFee(new java.math.BigDecimal(1.0));
		sObj.setTotalFinishOrderFee(new java.math.BigDecimal(1.0));
		sObj.setTotalFinishOrderCount(1);
		sObj.setUserLevelValidOrderFee(new java.math.BigDecimal(1.0));
		sObj.setUserLevelValidBuyCount(1);
		sObj.setUserLevelLastModifyTime(new java.util.Date());
		sObj.setUserLevelIsHandProtect(1);
		sObj.setPartnerType(1);
		sObj.setPayPassword("payPassword");
		sObj.setPaySalt("paySalt");
		sObj.setPayStatus(1);
		sObj.setBirthdaychanged(1);
		sObj.setProvince("province");
		sObj.setModifyPasswordDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerFake objInsert = new EcuserCustomerFake();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerFake]");
		dao.insert(objInsert);
		Integer key = objInsert.getEcUserId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcuserCustomerFakeTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcuserCustomerFake objSelect = dao.getEcuserCustomerFakeByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcuserCustomerFakeTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcuserCustomerFakeTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcuserCustomerFakeTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
