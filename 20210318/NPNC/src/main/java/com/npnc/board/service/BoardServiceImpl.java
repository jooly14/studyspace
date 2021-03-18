package com.npnc.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npnc.board.dao.BDao;
import com.npnc.board.dto.BDto;
import com.npnc.board.dto.CDto;
import com.npnc.board.dto.GDto;

@Service
public class BoardServiceImpl implements BoardService {
	public void hello() {
		System.out.println("hello");
	}
	@Autowired
	private BDao dao;
	
	@Override
	public Map<String, Object> getList(String type, String keyword, String category, int page,
			int pagesize) {
		List<BDto> dtos = dao.getList(type,keyword,category,(page-1)*pagesize,pagesize);
		int totalCnt = dao.getCnt();
		int totalpage = totalCnt/pagesize;		//��ü �Խñ� ����/�� ������ �� �Խñ� ���� = ��ü ������ ����
		if(totalCnt%pagesize!=0){				//�������� �ִ� ��쿡�� �� ������ �� �ʿ�
			totalpage++;
		}
		int pagelistsize = 10;					//����������Ʈ(�Խñ۸���Ʈ �ϴܿ� �ִ� ��������ũ�� �ǹ�) �ѹ��� �������� ������ ����(�������� ������ �̸� �ʰ��ϸ� ������ư�� ������)
		int start = (page/pagelistsize)*pagelistsize+1;	//����������Ʈ�� �����ϴ� ����
		if(page%pagelistsize==0){
			start = (page/pagelistsize-1)*pagelistsize+1;
		}
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("dtos", dtos);
		map.put("page", page);
		map.put("totalcnt", totalCnt);	
		map.put("totalpage", totalpage);
		map.put("pagesize", pagesize);
		map.put("end", start+pagelistsize-1);
		map.put("type", type);	
		map.put("keyword", keyword);
		map.put("category", category);	
		
		return map;
	}
	public Map<String, Object> getGradeList(){
		List<GDto> result_ = dao.getGradeList();
		HashMap<Integer, String> result = new HashMap<>();
		for(GDto g: result_) {
			result.put(g.getGrade(), g.getName());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("grades", result);
		return map;
	}
	
	public Map<String, Object> getCategoryList() {	//maincategory필드 값을 키 값으로 category테이블 값을 갖고 있는 CDto리스트를 가지고 있는 hashmap
		List<CDto> result_ = dao.getCategoryList();
		 HashMap<String, Vector<CDto>> result = new HashMap<>();
		 for(CDto c:result_) {
			 if(!result.containsKey(c.getMaincategory())) {
				 result.put(c.getMaincategory(),new Vector<CDto>());
			 }
			 result.get(c.getMaincategory()).add(c);
		 }
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clist", result);
		return map;
	}
}
