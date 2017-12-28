package com.sapient.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.serice.Palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;


@RunWith(JUnitPlatform.class)
public class RepeatTest {
	
	@RepeatedTest(5)
	public void test1(){
		Palindrome obj =new Palindrome();
		assertTrue(obj.checkPal("nitin"));
	}
}
