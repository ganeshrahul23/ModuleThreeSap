package com.sapient.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.exceptions.IdException;
import com.sapient.vo.Account;

public class DaoImpl implements IDao {
	private static Map<Integer,Account> aMap;
	
	private static Logger logger = LoggerFactory.getLogger("sapient");
	
	static{
		logger.trace("static block");
		aMap = new HashMap<>();
		aMap.put(1001, new Account(1001, "ram", 10000));
		aMap.put(1002, new Account(1002, "tom", 5000));
		aMap.put(1003, new Account(1003, "sam", 3000));
		logger.debug("hashmap inint");
	}

	@Override
	public Account getAccount(int aid) throws IdException {
		if(!aMap.containsKey(aid))
			throw new IdException("No Id found");
		logger.info("accound ID {} found", aid);
		logger.trace("hai");
		return aMap.get(aid);
	}

}
