package com.sapient.service;

import com.sapient.vo.Product;

public interface ISer {
	Product getProductInfo(String category, int pid) throws NotFoundException;
}
