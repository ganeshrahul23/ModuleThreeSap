package com.sapient.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.sapient.service.CalcService;
import com.sapient.service.Factory;
import com.sapient.service.Palindrome;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.time.Duration;

@RunWith(JUnitPlatform.class)
public class PalindromeTest {
	public void testRev(){
		Palindrome pal = Factory.getPalindrome();
		assumeTrue(pal != null);
		String [] input = Factory.getInput();
		assumeTrue(input != null && input.length >= 10);
		assertTimeout(Duration.ofNanos(10), () -> pal.reverseName(input));
	}
}
