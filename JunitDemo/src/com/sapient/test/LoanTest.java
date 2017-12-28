package com.sapient.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import com.sapient.serice.AgeException;
import com.sapient.serice.IncomeException;
import com.sapient.serice.LoanService;

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
