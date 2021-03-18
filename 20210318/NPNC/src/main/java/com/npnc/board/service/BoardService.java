package com.npnc.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public Map<String, Object> getList(String type,String keyword,String category,int page,int pagesize);
	public Map<String, Object> getGradeList();
	public Map<String, Object> getCategoryList();
	public void hello();
}
