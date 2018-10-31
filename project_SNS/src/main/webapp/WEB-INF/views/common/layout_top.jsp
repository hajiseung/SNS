<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.team.springsns.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/default.css">
<style type="text/css">
#logo {
	width: 150px;
	height: 50px;
	position: absolute;
	margin-top: 0;
}

.navbar {
	background-color: rgb(33, 57, 93); /* #00264B; */
	color: white;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#"><img src="images/logo2.png" id="logo"></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">마이페이지</a></li>
					<%
						MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");
						if (loginInfo == null) { /** userId와 같은 아이디로 세션이 없으면**/
					%><li><a href="<%=request.getContextPath()%>/loginForm">로그인</a></li>
					<%
						} else {
					%>
					<li><a href="<%=request.getContextPath()%>/team/logout">로그아웃</a></li>
					<%
						}
					%>

				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
					<button type="button" class="btn btn-default"><a href="check">검색</a></button>
				</form>
			</div>
		</div>
	</nav>

</body>
</html>