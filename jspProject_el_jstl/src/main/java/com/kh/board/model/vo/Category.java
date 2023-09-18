package com.kh.board.model.vo;

public class Category {
	
	// 전역변수
	private int categoryNo;
	private String categoryName;
	
	// 기본생성자
	public Category() {}
	
	// 전체 매개변수 생성자
	public Category(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	// getter-setter 메소드
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}

}
