<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@taglib prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
* {
    /*border: 1px solid red;*/
    padding: 0px;
    margin: 0px;
}

aside#left {
    width: 175px;
    margin-top: 20px;
    float: left;
}

#left h4 {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 20px;
}

#left ul {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 15px;
    color: #FFF;
    list-style: none;
    text-indent: 15px;
}

    #left ul li {
        background: #3f3f3f;
        line-height: 28px;
        border-bottom: 1px solid #333;
    }

        #left ul li a {
            text-decoration: none;
            color: #FFF;
            display: block;
        }

            #left ul li a:hover {
                background: #d40203;
            }

        #left ul li#active {
            background: #d40203;
        }

#main {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 12px;
    color: #464646;
    overflow: hidden;
    float: left;
    width: 1000px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="common.js" type="text/javascript"></script>
<script>

</script>
</head>
<body>
	<aside id="left">
		<h4>판매자 회원 관리 메뉴</h4>
		<ul>
			<li><a target="iframe1" href="admin_hosts.do">판매자 관리</a></li>
			<li><a target="iframe1" href="admin_host_request.do">신청리스트</a></li>
		</ul>
	</aside>
	<section id="main">
		<article id="article1">
			<iframe name="iframe1" src="admin_hosts.do" width="1000" height="1000" seamless></iframe>	
		</article>
	</section>
</body>
</html>