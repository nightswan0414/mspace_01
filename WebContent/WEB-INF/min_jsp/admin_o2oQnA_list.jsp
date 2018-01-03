<%@ page contentType="text/html;charset=utf-8" pageEncoding="euc-kr"%><%@
taglib
	prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

.form-group {
	text-align: center;
}

.jumbotron {
	text-align: center;
}

.btn {
	text-align: center;
}


</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>
	$(document).ready(function(){
		$("#cancel").on("click",function(){
			document.frm.method="POST";
			document.frm.action="admin_o2oQnA.do";
			document.frm.submit();
		});
	});

</script>
</head>
<body>
	<div class="jumbotron" style="background-color: orange">
		<h1>FAQ ���ǳ����</h1>
	</div>
	<table>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>�̸���</td>
			<td>��ȭ��ȣ</td>
			<td>Ÿ��</td>
		</tr>
		<jl:forEach var="vo" items="${ls}">
		<tr>
			<td>${vo.o2o_title}</td>
			<td>${vo.o2o_content}</td>
			<td>${vo.o2o_email}</td>
			<td>${vo.o2o_phone}</td>
			<td>${vo.o2o_type}</td>
		</tr>
		</jl:forEach>
	</table>
	<!--  
	<form action="admin_o2oQnA_add.do" class="form-group" method="POST" name="frm">
		���� : <input type="text" name="o2o_title" size="30" /> <br>
		�̸��� : <input type="text" name="o2o_email" size="30" /> <br>
		�ڵ�����ȣ : <input type="text" name="o2o_phone" size="30" /><br>
		���񽺺з� : <select name="o2o_type">
			<option value="����">�����ϼ���</option>
			<option value="ȸ��">ȸ��</option>
			<option value="���� �� ����">���� �� ����</option>
			<option value="��� �� ȯ��">��� �� ȯ��</option>
			<option value="��Ÿ">��Ÿ</option>
		</select> <br> ���� ����:
		<textarea name="o2o_content" rows="10" cols="60"></textarea>
		<br> <input class="btn btn-success" type="submit" value="�����ϱ�" />
		<input type="button"class="btn btn-success" id="cancel" value="����ϱ�"/>
	</form>
	-->


</body>
</html>