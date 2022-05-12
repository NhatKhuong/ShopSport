<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- denied page
	<br>
	Role: <sec:authentication property="principal.authorities"/> --%>
	<h1 class='text-danger'>Bạn không có quyền truy cập</h1>
	<a href='${pageContext.request.contextPath}/logout'>Nhấn vào đây để đăng nhập lại</a>

</body>
</html>