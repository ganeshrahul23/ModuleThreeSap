package com.sapient.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.EmpService;
import com.sapient.service.Factory;
import com.sapient.service.NotFoundException;
import com.sapient.vo.Emp;

@RunWith(JUnitPlatform.class)
public class EmpTest {

	@Test
	public void testEmp1() {
		Emp e1 = new Emp(1001, "ram", 90000);
		Emp e2 = new Emp(1001, "ram", 90000);
		assertEquals(e1, e2);// to use assert equals for user defined instance
								// then override equals() in Emp class otherwise
								// only reference will be compared
	}

	@Test
	public void testEmp2() throws NotFoundException {
		EmpService ser = Factory.getEmpService();
		assumeTrue(ser != null);
		Emp expected = new Emp(1002, "tom", 15000.0);
		try {
			assertEquals(expected, ser.getEmployee(1002));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void testEmp3() throws NotFoundException, SQLException {
		EmpService ser = Factory.getEmpService();
		assumeTrue(ser != null);
		Emp expected = new Emp(1003, "sam", 23000.0);
		Emp actual = ser.getEmployee(1003);
		assertAll("test all states", () -> assertEquals(expected.getEid(), actual.getEid()),
				() -> assertEquals(expected.getEname(), actual.getEname()),
				() -> assertEquals(expected.getSal(), actual.getSal()));
	}

	@Test
	public void testEmp4() throws NotFoundException {
		EmpService ser = Factory.getEmpService();
		assumeTrue(ser != null);
		assertThrows(NotFoundException.class, () -> ser.getEmployee(1016));
	}

}
