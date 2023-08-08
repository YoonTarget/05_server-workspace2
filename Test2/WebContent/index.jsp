<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1 align="center">회원 정보 조회</h1>
	<br>
	<ul>
		<li>
			<form action="/Test2/name.do">
				<table>
					<tr>
						<th>
							이름으로 조회(키워드 입력) 
						</th>
						<td>
							<input type="text" name="userName" required>
						</td>
					</tr>
				</table>
				<button type="submit">조회</button>
			</form>
		</li>
	</ul>
</body>
</html>