package com.sapient.service;

import com.sapient.exceptions.BalException;
import com.sapient.exceptions.IdException;

public interface ISer {
	public boolean transferFund(int fid, int tid, double amt) throws BalException, IdException;
}
