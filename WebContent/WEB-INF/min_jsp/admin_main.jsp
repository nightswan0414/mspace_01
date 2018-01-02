<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="jl" uri="http://java.sun.com/jsp/jstl/core"%>   
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
		<h4>관리 항목들</h4>
		<ul>
			<li><a target="iframe1" href="admin_user_main.do">회원 관리</a></li>
			<li><a target="iframe1" href="admin_host_main.do">판매자 관리</a></li>
			<li><a target="iframe1" href="admin_space.do">물품 관리</a></li>
			<li><a target="iframe1" href="admin_gathering.do">모임 관리</a></li>
			<li><a target="iframe1" href="admin_community.do">커뮤니티 관리</a></li>
			<li><a target="iframe1" href="admin_announcement.do">공지사항 관리</a></li>
			<li><a target="iframe1" href="admin_event.do">이벤트 관리</a></li>
			<li><a target="iframe1" href="admin_faq.do">FAQ 관리</a></li>
			<li><a target="iframe1" href="admin_one_one.do">1:1 관리</a></li>
		</ul>
	</aside>
	<section id="main">
		<article id="article1">
			<iframe name="iframe1" src="admin_user_main.do" width="1300" height="1300" seamless></iframe>	
		</article>
	</section>
</body>
</html>