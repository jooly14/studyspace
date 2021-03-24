package com.npnc.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.npnc.board.dto.BDto;
import com.npnc.board.dto.CDto;
import com.npnc.board.dto.GDto;

public interface BDao {
	
	public List<BDto> getList(@Param("type")String type,@Param("keyword") String keyword,@Param("category") String category,@Param("page") int page,@Param("pagesize")int pagesize);
	public int getCnt();
	public List<GDto> getGradeList();
	public List<CDto> getCategoryList();
}
