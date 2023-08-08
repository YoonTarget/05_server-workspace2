<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>회원 정보 검색(회원 번호 검색)</h1>
	<form action="/Test1/test.do">
		<input type="text" placeholder="회원 번호 입력" name="userNo">
		<input type="submit" value="조회">
	</form>

	<br>

	<form action="/Test1/login.do" method="post">
		<table>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="userId" required>
				</td>
			</tr>
			<tr>
				<th>
					나이
				</th>
				<td>
					<input type="number" name="userAge" required>
				</td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>