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
		<td>${vo.CRN}</td>
		<td>${vo.user_id}</td>
		<td>${vo.host_name}</td>
		<td>${vo.host_account}</td>
		<td>${vo.zipcode}</td>
	</tr>
</table>

</body>
</html>