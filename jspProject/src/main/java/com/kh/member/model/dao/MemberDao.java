package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String filepath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		
		// select문 => ResultSet 객체(한 행) => Member 객체
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql); // 미완성된 쿼리
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery(); // 조회된 결과가 있다면 한 행 조회 | 조회된 결과가 없다면 아무것도 안 담김
			
			if(rset.next()) {
				m = new Member(rset.getInt("user_no"), 
								rset.getString("user_id"), 
								rset.getString("user_pwd"), 
								rset.getString("user_name"), 
								rset.getString("phone"), 
								rset.getString("email"), 
								rset.getString("address"), 
								rset.getString("interest"), 
								rset.getDate("enroll_date"), 
								rset.getDate("modify_date"), 
								rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(rset);
			/*JDBCTemplate.*/close(pstmt);
		}
		
		return m;
		
	}
	
	public int insertMember(Connection conn, Member m) {
		
		// insert문 => 처리된 행 수 => 트랜젝션 처리
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateMember(Connection conn, Member m) {
		
		// update문 => 처리된 행 수 => 트랜젝션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql); // 미완성된 쿼리
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Member selectMember(Connection conn, String userId) {
		// select문 => 한 행 => ResultSet 객체 => Member 객체
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("user_no"), 
						rset.getString("user_id"), 
						rset.getString("user_pwd"), 
						rset.getString("user_name"), 
						rset.getString("phone"), 
						rset.getString("email"), 
						rset.getString("address"), 
						rset.getString("interest"), 
						rset.getDate("enroll_date"), 
						rset.getDate("modify_date"), 
						rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	public int updatePwd(Connection conn, String userId, String userPwd, String updatePwd) {
		
		//update문 => 처리된 행 수 => 트랜젝션 처리
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwd");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		// 처리된 행 수를 받아줄 변수 초기화
		int result = 0;
		
		// sql문 처리를 위한 변수 초기화
		PreparedStatement pstmt = null;
		
		// xml 파일에 작성된 sql문 불러오기
		String sql = prop.getProperty("deleteMember");
		
		try {
			// sql문과 연결할 준비
			pstmt = conn.prepareStatement(sql);
			
			// ?로 처리된 값에 매개변수 입력
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			// 완성된 sql문으로 처리된 행 수 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// sql문 처리 작업이 끝났으니 객체 반납
			close(pstmt);
		}
		
		// 처리된 행 수 반환
		return result;
		
	}
	
	public int idCheck(Connection conn, String checkId) {
		// select문 => ResultSet => 한 개 숫자 => int
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}

}
