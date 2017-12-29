package com.sapient.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.CalcService;
import com.sapient.service.Factory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@RunWith(JUnitPlatform.class)
public class CalcTest {
	
	@Test
	public void testSeries1(){
		CalcService ser = Factory.getCalcService();
		assumeTrue(ser != null);
		assertEquals(7.5d, ser.calcSeries(5, 5, 5));	
	}
	
	@Test
	public void testSeries2(){
		CalcService ser = Factory.getCalcService();
		assumingThat(ser != null, () -> assertEquals(7.5d, ser.calcSeries(5, 5, 5)));	
	}

}
