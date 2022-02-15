package com.school.page;

import org.apache.ibatis.type.Alias;

@Alias("Criteria")
public class Criteria {
	
	//현재페이지
	private int pageNum;
	
	//한페이지 당 보여질 게시물 개수
	private int amount;
	
	//스킵 할 게시물 수 ((pageNum-1)*amount)
	private int skip;
	
	//검색할 타입
	private String searchType;
	
	//검색타입 배열
	private String[] searchTypeArr;
	
	//검색할 키워드
	private String keyword;
	
	//학년
	private String sGrade;
	//반
	private String sClass;
	
	
	//기본 초기 생성자 - > 기본세팅: pageNum = 1, amount = 15;
	public Criteria() {
		this(1,15);
		this.skip=0;
	}
	
	//생성자=> 원하는 pageNum,원하는 amount
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip= (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip= (pageNum-1)*amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
		this.searchTypeArr = searchType.split("");
	}

	public String[] getSearchTypeArr() {
		return searchTypeArr;
	}

	public void setSearchTypeArr(String[] searchTypeArr) {
		this.searchTypeArr = searchTypeArr;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getsGrade() {
		return sGrade;
	}

	public void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
	
	
}
