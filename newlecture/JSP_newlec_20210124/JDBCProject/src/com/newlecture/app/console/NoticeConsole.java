package com.newlecture.app.console;

import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

public class NoticeConsole {
	private NoticeService service;
	private int page;
	private String searchField;
	String searchWord;
	
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchField = "TITLE";
		searchWord = "";
	}
	public void printNoticeList() {
		List<Notice> list = service.getList(page,searchField,searchWord);
		int count = service.getCount();
		int lastpage = count%10==0?count/10:count/10+1;
		System.out.println("──────────────────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("──────────────────────────────────");
		for(Notice n:list) {
			System.out.printf("%d. %s / %s / %s\n", n.getId(),n.getTitle(),n.getWriterId(),n.getRegDate());
		}
		System.out.println("──────────────────────────────────");
		System.out.printf("%d/%d pages\n", page, lastpage);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.검색/ 6.종료 > ");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		scan.close();
		return menu;
	}
	public void movePrevList() {
		if(page==1) {
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
			page--;
		
	}
	public void moveNextList() {
		int count = service.getCount();
		int lastpage = count%10==0?count/10:count/10+1;
		if(page==lastpage) {
			System.out.println("다음 페이지가 없습니다.");
			return;
		}
		page++;
	}
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색범주를 입력하세요(title/content/writerId) > ");
		searchField  = scan.nextLine();
		System.out.print("검색어 > ");
		searchWord  = scan.nextLine();
		scan.close();
	}
	
}
