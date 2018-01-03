<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@taglib prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="common.js" type="text/javascript"></script>
<script>

</script>
</head>
<body>
<h1>판매자 신청 정보</h1>
<table border="1">
	<tr>
		<td>사업자 번호</td>
		<td>유저 ID</td>
		<td>판매자 이름</td>
		<td>판매자 계좌</td>
		<td>주소</td>
	</tr>
	<tr>
		<td>${vo.crn}</td>
		<td>${vo.user_id}</td>
		<td>${vo.host_name}</td>
		<td>${vo.host_account}</td>
		<td>${vo.zipcode}</td>
	</tr>
</table>

<form method="post" action="admin_host_user_accept.do">
	<input type="hidden" name="user_id" value="${vo.user_id}"></input>
	<button type="submit">판매자 등록</button>
</form>
<form method="post" action="admin_host_user_refuse.do">
	<input type="hidden" name="crn" value="${vo.crn}"></input>
	<button type="submit">거절</button>
</form>
<form method="post" action="admin_host_request.do">
	<button type="submit">취소</button>
</form>

</body>
</html>