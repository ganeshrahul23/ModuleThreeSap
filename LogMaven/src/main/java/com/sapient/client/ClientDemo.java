package com.sapient.client;

import com.sapient.dao.DaoImpl;
import com.sapient.dao.IDao;
import com.sapient.exceptions.BalException;
import com.sapient.exceptions.IdException;
import com.sapient.service.ISer;
import com.sapient.service.SerImpl;

public class ClientDemo {
	public static void main(String[] args) throws BalException, IdException {
		IDao dao = new DaoImpl();
		ISer ser = new SerImpl();
		ser.setDao(dao);		
		ser.transferFund(1001, 1002, 3000);
	}
}
