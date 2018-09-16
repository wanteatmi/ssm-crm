package com.wut.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wut.boot.dao.CustomerDao;
import com.wut.boot.pojo.Customer;
import com.wut.boot.pojo.QueryVo;
import com.wut.boot.service.CustomerService;
import com.wut.boot.utils.Page;
/*
 * 客户管理
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@Override
	public Page<Customer> getCustomerList(QueryVo queryvo) {
		//计算分页起始记录
		if(queryvo.getPage()!=null){
			queryvo.setStart((queryvo.getPage() - 1)*queryvo.getSize());
		}
		List<Customer> customerList = customerDao.getCustomerList(queryvo);
		//创建一个Page对象
		Page<Customer> page = new Page<>();
		page.setRows(customerList);
		//查询总记录数
		Integer count = customerDao.getCustomerListCount(queryvo);
		page.setTotal(count);
		page.setSize(queryvo.getSize());
		page.setPage(queryvo.getPage());
		//返回结果
		return page;
	}
	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
	}

}
