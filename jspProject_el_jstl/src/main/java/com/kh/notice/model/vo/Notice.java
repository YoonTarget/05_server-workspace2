package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	// 전역변수
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeWriter; // 작성하기 기능은 회원번호 | 조회시 작성자 아이디
	private int count;
	private Date createDate;
	private String status;
	
	// 기본생성자
	public Notice() {}

	// 전체 매개변수 생성자
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, int count,
			Date createDate, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}
	
	// 공지사항 조회용 매개변수 생성자
	public Notice(int noticeNo, String noticeTitle, String noticeWriter, int count, Date createDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
	}
	
	// 공지사항 세부조회용 매개변수 생성자
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String noticeWriter, Date createDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.createDate = createDate;
	}

	// getter-setter 메소드
	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString() 메소드
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", count=" + count + ", createDate=" + createDate + ", status="
				+ status + "]";
	}

}
