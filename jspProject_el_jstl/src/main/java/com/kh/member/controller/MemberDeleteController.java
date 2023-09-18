package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// myPage.jsp에서 입력받은 값을 변수에 담기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// MemberService로 값을 보낸 후에 받은 결과값을 변수에 담기
		int result = new MemberService().deleteMember(userId, userPwd);
		
		// session 얻어오기
		HttpSession session = request.getSession();

		// 성공했을 경우에는
		if(result > 0) {
			// 성공 alert 메시지를 띄워주고
			session.setAttribute("alertMsg", "성공적으로 회원탈퇴 되었습니다. 그동안 이용해주셔서 감사합니다.");
			// session.setAttribute("loginMember", null);
			// 기존에 로그인 됐던 정보는 삭제해준다.
			session.removeAttribute("loginMember");
			// 프로젝트에 접속했을 때 가장 먼저 만나게 되는 경로로 url을 재요청한다.
			response.sendRedirect(request.getContextPath());
		}
		// 실패했을 경우에는
		else {
			// 실패 alert 메시지를 띄워주고
			session.setAttribute("alertMsg", "회원탈퇴 실패!!");
			// 마이페이지로 이동한다. (프로젝트 최초 경로 => 마이페이지)
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
