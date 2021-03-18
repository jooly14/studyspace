package com.joo.mybatis;

import java.util.List;

public interface Dao {
	public List<MDto> getAll();
	public void insert(MDto dto);
}
