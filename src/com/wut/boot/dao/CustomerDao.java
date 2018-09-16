package com.wut.boot.dao;

import java.util.List;

import com.wut.boot.pojo.Customer;
import com.wut.boot.pojo.QueryVo;

public interface CustomerDao {
	List<Customer> getCustomerList(QueryVo queryVo);
	Integer getCustomerListCount(QueryVo queryVo);
	Customer getCustomerById(Long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
