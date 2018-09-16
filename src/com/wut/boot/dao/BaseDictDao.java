package com.wut.boot.dao;

import java.util.List;

import com.wut.boot.pojo.BaseDict;

public interface BaseDictDao {
	List<BaseDict> getDictListByTypeCode(String typeCode);
}
