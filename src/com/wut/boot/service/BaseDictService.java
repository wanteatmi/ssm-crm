package com.wut.boot.service;

import java.util.List;

import com.wut.boot.pojo.BaseDict;

public interface BaseDictService {
	List<BaseDict> getDictListByTypeCode(String typeCode);
}
