<%@ page contentType="text/html;charset=utf-8" pageEncoding="euc-kr"%>
<%@ taglib prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- ��ҿ� -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
	

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>
$(document).ready(function(){
	$("#faq_can").on("click",function(){
		document.frm.action="admin_faq.do";
		document.frm.submit();
	});
});
</script>
</head>
<body>
	<form method="post" action="admin_faq_mod.do" name="frm">
		<input type="hidden" name="faq_no" value="${vo.faq_no}" >
		FAQ ���� : <input type="text" name="faq_title" value="${vo.faq_title}" /> <br/>
		FAQ ���� : <input type="text" name="faq_content" value="${vo.faq_content}" /> <br/>
		<button type="submit"> ���� �ϱ�</button>&nbsp;&nbsp;
		<button id="faq_can" type="submit"> ��� �ϱ�</button>
	</form>

</body>
</html>