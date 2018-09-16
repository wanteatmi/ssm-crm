package com.wut.boot.service;

import com.wut.boot.pojo.Customer;
import com.wut.boot.pojo.QueryVo;
import com.wut.boot.utils.Page;

public interface CustomerService {
	Page<Customer> getCustomerList(QueryVo queryvo);
	Customer getCustomerById(Long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
