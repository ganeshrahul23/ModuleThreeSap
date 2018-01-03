package com.sapient.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({ CalcTest.class, LoanTest.class, PalTest.class, ReverseTest.class, RoundTest.class })
@SelectPackages("com.sapient.test")
public class AllTests {

}
