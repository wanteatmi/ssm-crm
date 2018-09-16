package com.wut.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wut.boot.dao.BaseDictDao;
import com.wut.boot.pojo.BaseDict;
import com.wut.boot.service.BaseDictService;
/*
 * ×Öµä±í´¦ÀíService
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> getDictListByTypeCode(String typeCode) {
		List<BaseDict> list = baseDictDao.getDictListByTypeCode(typeCode);
		return list;
	}

}
