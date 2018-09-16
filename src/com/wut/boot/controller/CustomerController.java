package com.wut.boot.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wut.boot.pojo.BaseDict;
import com.wut.boot.pojo.Customer;
import com.wut.boot.pojo.QueryVo;
import com.wut.boot.service.BaseDictService;
import com.wut.boot.service.CustomerService;
import com.wut.boot.utils.Page;

/*
 * �ͻ�����
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	@Value("${customer.source.code}")
	private String custSorceCode;
	@Value("${customer.industory.code}")
	private String custIndustoryCode;
	@Value("${customer.level.code}")
	private String custLevelCode;
	
	@RequestMapping("/customer/list")
	public String ShowCustomerList(QueryVo queryVo,Model model) throws UnsupportedEncodingException{
		//���봦��
		if(StringUtils.isNotBlank(queryVo.getCustName())){
			queryVo.setCustName(new String(queryVo.getCustName().getBytes("iso8859-1"),"utf-8"));
		}
		//��ʼ���ͻ���Դ
		//System.out.println("11111");
		List<BaseDict> sourceList = baseDictService.getDictListByTypeCode(custSorceCode);
		//������ҵ
		List<BaseDict> industoryList = baseDictService.getDictListByTypeCode(custIndustoryCode);
		//�ͻ�����
		List<BaseDict> levelList = baseDictService.getDictListByTypeCode(custLevelCode);
		//���ֵ���Ϣ���ݸ�ҳ��
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industoryList);
		model.addAttribute("levelType", levelList);
		Page<Customer> page = customerService.getCustomerList(queryVo);
		//�ѿͻ��б��ݸ�ҳ��
		model.addAttribute("page", page);
		//��������
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping("/customer/edit")
	@ResponseBody
	public Customer getCustomerById(Long id){
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	@RequestMapping(value="/customer/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(Customer customer ){
		customerService.updateCustomer(customer);
		return "ok";
	}
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer(Long id){
		customerService.deleteCustomer(id);
		return "ok";
	}
}
