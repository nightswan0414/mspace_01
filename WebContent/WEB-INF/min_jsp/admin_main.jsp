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
    width: 1300px;
}

#user_manage {
	background: #FF7000 !important;
}
#user_stastic {
	background: #FF7000 !important;
}
#host_manage {
	background: #FF7000 !important;
}
#host_requests {
	background: #FF7000 !important;
}

#community_free {
	background: #FF7000 !important;
}
#community_review {
	background: #FF7000 !important;
}
#community_question {
	background: #FF7000 !important;
}


#admin_announcement {
	background: #FF7000 !important;
}
#admin_event {
	background: #FF7000 !important;
}
#admin_faq {
	background: #FF7000 !important;
}
#admin_one_one {
	background: #FF7000 !important;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="common.js" type="text/javascript"></script>
<script>
 $("document").ready(function(){
	$("#user_manage").hide();
	$("#user_stastic").hide();
	
	$("#host_manage").hide();
	$("#host_requests").hide();
	
	$("#community_free").hide();
	$("#community_review").hide();
	$("#community_question").hide();
	
	$("#admin_announcement").hide();
	$("#admin_event").hide();
	$("#admin_faq").hide();
	$("#admin_one_one").hide();
	
	$("#user").on("click",function(){
		$("#user_manage").show();
		$("#user_stastic").show();
		
		$("#host_manage").hide();
		$("#host_requests").hide();
		$("#community_free").hide();
		$("#community_review").hide();
		$("#community_question").hide();
		$("#admin_announcement").hide();
		$("#admin_event").hide();
		$("#admin_faq").hide();
		$("#admin_one_one").hide();
	});
	
	$("#host").on("click",function(){
		$("#host_manage").show();
		$("#host_requests").show();
		
		$("#user_manage").hide();
		$("#user_stastic").hide();
		$("#community_free").hide();
		$("#community_review").hide();
		$("#community_question").hide();
		$("#admin_announcement").hide();
		$("#admin_event").hide();
		$("#admin_faq").hide();
		$("#admin_one_one").hide();
	});
	
	$("#community").on("click",function(){
		$("#community_free").show();
		$("#community_review").show();
		$("#community_question").show();
		
		$("#user_manage").hide();
		$("#user_stastic").hide();
		$("#host_manage").hide();
		$("#host_requests").hide();
		$("#admin_announcement").hide();
		$("#admin_event").hide();
		$("#admin_faq").hide();
		$("#admin_one_one").hide();
	});
	
	$("#admin_user").on("click",function(){
		$("#admin_announcement").show();
		$("#admin_event").show();
		$("#admin_faq").show();
		$("#admin_one_one").show();
		
		$("#user_manage").hide();
		$("#user_stastic").hide();
		$("#host_manage").hide();
		$("#host_requests").hide();
		$("#community_free").hide();
		$("#community_review").hide();
		$("#community_question").hide();
	});
	
 });
</script>
</head>
<body>
	
	<aside id="left">
		<h4>관리 항목들</h4>
		<ul>
			<li id="user">회원 관리 항목</li>
			<li id="user_manage"><a target="iframe1" href="admin_users.do">일반 회원 관리</a></li>
			<li id="user_stastic"><a target="iframe1" href="admin_user_stastic.do">방문자 통계</a></li>
			
			<li id="host">판매자 관리 항목</li>
			<li id="host_manage"><a target="iframe1" href="admin_hosts.do">판매자 회원 관리</a></li>
			<li id="host_requests"><a target="iframe1" href="admin_host_request.do">신청리스트</a></li>
			
			<li><a target="iframe1" href="admin_space.do">물품 관리</a></li>
			
			<li><a target="iframe1" href="admin_gathering.do">모임 관리</a></li>
			
			<li id="community">커뮤니티 관리</li>
			<li id="community_free"><a target="iframe1" href="#">자유 게시판 관리</a></li>
			<li id="community_review"><a target="iframe1" href="#">후기 게시판 관리</a></li>
			<li id="community_question"><a target="iframe1" href="#">Q&A 관리</a></li>
			
			<li id="admin_user">공지 항목 관리</li>
			<li id="admin_announcement"><a target="iframe1" href="admin_notice_list.do">공지 관리</a></li>
			<li id="admin_event"><a target="iframe1" href="admin_event.do">이벤트 관리</a></li>
			<li id="admin_faq"><a target="iframe1" href="admin_faq.do">FAQ 관리</a></li>
			<li id="admin_one_one"><a target="iframe1" href="admin_o2oQnA.do">1:1 관리</a></li>	
		</ul>
	</aside>
	
	
	<section id="main">
		<article id="article1">
			<iframe name="iframe1" src="admin_users.do" width="1300" height="1000" seamless></iframe>	
		</article>
	</section>
</body>
</html>