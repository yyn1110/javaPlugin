package com.yao.yz.kubauser;

import com.yao.yz.kubauser.persistence.model.EcquyiMedicine;
import com.yao.yz.kubauser.persistence.dao.EcquyiMedicineDao;
import com.yao.yz.kubauser.exception.UnitTestException;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EcquyiMedicineTest extends AbstractTest {
	private static final Logger LOGGER = Logger.getLogger(EcquyiMedicine.class);
	@Autowired
	private EcquyiMedicineDao dao;

	private void setObjVal(EcquyiMedicine sObj) {
		sObj.setUserId("userId");
		sObj.setItemNo("itemNo");
		sObj.setDrugSpec("drugSpec");
		sObj.setDrugName("drugName");
		sObj.setFirm("firm");
		sObj.setPackageSpec("packageSpec");
		sObj.setQuantity("quantity");
		sObj.setPackageUnits("packageUnits");
		sObj.setDosage("dosage");
		sObj.setDosageUnits("dosageUnits");
		sObj.setFrequency("frequency");
		sObj.setFrequencyCounter("frequencyCounter");
		sObj.setFrequencyInterval("frequencyInterval");
		sObj.setFrequencyIntervalUnit("frequencyIntervalUnit");
		sObj.setFrequencyDetailDescription("frequencyDetailDescription");
		sObj.setAdministration("administration");
		sObj.setDuration("duration");
		sObj.setDurationUnits("durationUnits");
		sObj.setCreateDate(new java.util.Date());
		sObj.setRemark("remark");
	}

	@Test
	public void testCase() throws UnitTestException {
		EcquyiMedicine objInsert = new EcquyiMedicine();
		setObjVal(objInsert);

		LOGGER.info("+ [EcquyiMedicine]");
		dao.insert(objInsert);
		Integer key = objInsert.getId();
		if (key == null || key == 0) {
			throw new UnitTestException("EcquyiMedicineTest", "test of insert is failed");
		}
		LOGGER.info("	insert OK");

		EcquyiMedicine objSelect = dao.getEcquyiMedicineByKey(key);
		if (objSelect == null) {
			throw new UnitTestException("EcquyiMedicineTest", "test of select is failed");
		}
		LOGGER.info("	select OK");

		Integer res = dao.update(objSelect);
		if (res == null || res == 0) {
			throw new UnitTestException("EcquyiMedicineTest", "test of update is failed");
		}
		LOGGER.info("	update OK");

		Integer del = dao.delete(key);
		if (del == null || del == 0) {
			throw new UnitTestException("EcquyiMedicineTest", "test of delete is failed");
		}
		LOGGER.info("	delete OK");

	}

}
