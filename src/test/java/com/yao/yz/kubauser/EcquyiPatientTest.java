package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcquyiPatient;
import com.yao.yz.kubauser.persistence.dao.EcquyiPatientDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcquyiPatientTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcquyiPatient.class);
	@Autowired
	private EcquyiPatientDao dao;

	private void setObjVal(EcquyiPatient sObj) {
		sObj.setUserId("userId");
		sObj.setRegisterId("registerId");
		sObj.setHospitalId("hospitalId");
		sObj.setHospitalName("hospitalName");
		sObj.setDoctorId("doctorId");
		sObj.setPrescriptionNo("prescriptionNo");
		sObj.setPrescriptionDate(new java.util.Date());
		sObj.setDepartmentName("departmentName");
		sObj.setPatientId("patientId");
		sObj.setPatientName("patientName");
		sObj.setGender("gende");
		sObj.setAge(1);
		sObj.setPhoneNumber("phoneNumber");
		sObj.setAddress("address");
		sObj.setDiagnosis("diagnosis");
		sObj.setPrescriptionType(1);
		sObj.setPrescriptionSource(1);
		sObj.setComment("comment");
		sObj.setStatus(1);
		sObj.setCardNo("cardNo");
		sObj.setVerify("verify");
		sObj.setChecks("checks");
		sObj.setDeploy("deploy");
		sObj.setAssign("assign");
		sObj.setCreateDate(new java.util.Date());
	}

	@Test
	public void testCase() throws UnitTestException {
		EcquyiPatient objInsert = new EcquyiPatient();
		setObjVal(objInsert);

		LOGGER.info("+ [EcquyiPatient]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcquyiPatientTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcquyiPatient objSelect = dao.getEcquyiPatientByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcquyiPatientTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcquyiPatientTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcquyiPatientTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
