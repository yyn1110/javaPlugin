package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcuserCustomerLevel1;
import com.yao.yz.kubauser.persistence.dao.EcuserCustomerLevel1Dao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcuserCustomerLevel1Test extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcuserCustomerLevel1.class);
	@Autowired
	private EcuserCustomerLevel1Dao dao;

	private void setObjVal(EcuserCustomerLevel1 sObj) {
		sObj.setEcUserId(1);
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
	}

	@Test
	public void testCase() throws UnitTestException {
		EcuserCustomerLevel1 objInsert = new EcuserCustomerLevel1();
		setObjVal(objInsert);

		LOGGER.info("+ [EcuserCustomerLevel1]");
		dao.insert(objInsert);
		dao.insert(objInsert);
		LOGGER.info("	insert OK");

	}

}
