<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="euc-kr"%>
<%@taglib prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		.jumbotron{
			text-align:center;
		}
		.container{
			height : 50px;
		}
		.content{
			height : 100px;
		}
	
	</style>
</head>
<body>

	<div id="i" class="jumbotron panel-primary">
		<h1>��������</h1>
	</div>
	<div class="container">
		<div class="title">
			<label>����:</label>
			<span>${vo.notice_title}</span><br>
		</div>
		
		<div class="content">
			<label>����</label><br/>
			<span>${vo.notice_content}</span><br/>
		</div>
	
		<form action="admin_notice_list.do" method="post">
			<input type="submit" value="�������"/>
		</form>
		<form action="admin_notice_mod.do" method="post">
			<input type="hidden" name="notice_no" value="${vo.notice_no}"/>
			<input type="hidden" name="notice_title" value="${vo.notice_title}"/>
			<input type="hidden" name="notice_content" value="${vo.notice_content}"/>
			<input type="submit" value="��������"/>
		</form>
		<form action="admin_notice_del.do" method="post">
			<input type="hidden" name="notice_no" value="${vo.notice_no}"/>
			<input type="submit" value="��������"/>
		</form>
		
	</div>
</body>
</html>