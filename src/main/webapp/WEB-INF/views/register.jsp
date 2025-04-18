<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		${ UserSession.name } 님 환영합니다.
		<form action = "../valid/insert"  		method= "post">
			<input type = "text"  			name = "title"><br/>
			${validError.title}<br/>
			<input type = "text"  			name = "content"><br/>
			${validError.content}<br/>
			<input type = "number"  		name = "priority"><br/>
			${validError.priority}<br/>
			<input type = "text"			name = "phone"><br/>
			${validError.phone}<br/>
			<input type = "submit"  		name = "작성하기">
		</form>
</body>
</html>