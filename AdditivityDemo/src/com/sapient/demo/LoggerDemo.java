package com.sapient.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDemo {

	public static void main(String[] args) {
		Logger root = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		Logger com = LoggerFactory.getLogger("com");
		Logger com_sap = LoggerFactory.getLogger("com.sap");
		
		root.debug("root message 1");
		com.debug("com message 1");
		com_sap.debug("com.sapient message 1");
	}

}
