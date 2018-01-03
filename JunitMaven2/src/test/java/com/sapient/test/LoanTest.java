package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.AgeException;
import com.sapient.service.IncomeException;
import com.sapient.service.LoanService;

@RunWith(JUnitPlatform.class)

public class LoanTest {
	private static LoanService ser = null;
	
	@BeforeAll
	public static void beforeAll(){
		ser = new LoanService();
	}
		
	@Test
	public void loanTest1() throws AgeException, IncomeException{
		String expected = ser.approveLoan(20, 400000);
		assertEquals(expected, "approved");
	}
	
	@Test
	public void loanTest2(){
		assertThrows(AgeException.class, () -> ser.approveLoan(17, 600000));
	}
	
	@Test
	public void loanTest3(){
		assertThrows(IncomeException.class, () -> ser.approveLoan(25, 399000));
		
	}
	
	@Test
	public void loanTest4() throws AgeException, IncomeException{
		String expected = ser.approveLoan(40, 400000);
		assertEquals(expected, "approved");
	}
	
	@Test
	public void loanTest5(){
		assertThrows(AgeException.class, () -> ser.approveLoan(19, 300000));
		
	}

}
