<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="com.newlecture.web.view.NoticeView"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 이걸 건드리니까 맛탱이가 감;;; -->

<%  //코드이해안가..
	//../notice.jap?p=5 -->
	String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");
	//요청하는 방법이 3가지
	
	//딱 눌렀을때 기본값을 page1으로 갈 수 있게 한 것.
	int pg = 1;
	String field = "TITLE";
	String query = "";
	
	if(_page != null && !_page.equals("")) //값이 넘겨진 것이 있다면
	 	pg = Integer.parseInt(_page);
	
	if(_field != null && !_field.equals("")) //값이 넘겨진 것이 있다면
	 	field = _field;
	
	if(_query != null && !_query.equals("")) //값이 넘겨진 것이 있다면
	 	query = _query;

	NoticeDao noticeDao = new MySQLNoticeDao();
	//page 번호를 요청하는 것?
	List<NoticeView> list = noticeDao.getList(pg, field, query);
	
	int size = noticeDao.getSize(field,query);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/customer/layout.css" type="text/css" rel="stylesheet" />
<link href="../css/customer/style.css" type="text/css" rel="stylesheet" />
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<script>
		window.add = function(){
			
		var btnResult = document.getElementByld("btn-result");
		btnResult.onclick = printResult;
		
		function printResult(){
			var x,y;
			x=prompt("x값을 입력하세요",0)
			y=prompt("y값을 입력하세요",0)
			x=parseInt(x);
			y=parseInt(y);
			btnResult.value=x+y;
			
		}
	}
	</script>
</head>
<body>

	<script>

</script>
	<!--------------------------header-------------------------------->
	<header id="header">
		<div class="content-container">
			<h1 id="logo">
				<img src="../images/logo.png" alt="뉴렉처 온라인" />
			</h1>

			<section>
				<h2 class="hidden">헤더</h2>
				<!-------------------------메인메뉴--------------------------------->
				<nav id="main-menu" class="hr-menu">
					<h1 class="">
						메인메뉴 <input type="button" value="클릭" id="btnResult"
							onclick="printResult();" />
					</h1>
					<ul>
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>

				<div id="lecture-search-form">
					<h3 class="hidden">강좌검색폼</h3>
					<form>
						<fieldset>
							<legend class="hidden">검색 필드</legend>
							<label>과정검색</label> <input type="text" /> <input
								class="lecture-search-botton" type="submit" value="검색" />
						</fieldset>
					</form>
				</div>

				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">계정메뉴</h1>
					<ul>
						<li class="first"><a href="../index.html">HOME</a></li>
						<li><a href="../joinus/login.html">로그아웃</a></li>
						<li><a href="../joinus/login.html">회원가입</a></li>
					</ul>
				</nav>

				<nav id="member-menu" class="hr-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><img src="../images/txt-mypage.png" alt="뉴렉처 온라인" /></li>
						<li><a href=""> <img src="../images/txt-customer.png"
								alt="뉴렉처 온라인" /></a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>
	<!--------visual--------------------------------------------------- -->
	<div id="visual">
		<div class="content-container">
			<!-- visual -->
		</div>
	</div>
	<!-- ------body--------------------------------------------------- -->
	<div id="body">
		<!---------------------- 섹션과 메인을 div로 묶어줌 -------------------->
		<div class="content-container clearfix ">
		<!-- clearfix :왼쪽으로 치우쳐지만 메인을 내용만큼 쓸수있음 -->
			<aside id="aside">
				<!-- div를 시맨틱하게 태그로 표현 (nav, article, aside) -->
				<!--    Section 내에서 헤더 푸터 따로 사용 가능. 메인은 사용 불가능 (문서 내 메인은 단 하나만 존재해야함 ) -->
				<h1 class="aside-title aside-main-title ">고객센터</h1>

				<nav class="aside-title aside-margin">
					<h1 class="hidden">고객센터 메뉴</h1>
					<ul>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">공지사항</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">1:1고객문의</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">학습안내</a></li>
					</ul>

				</nav>

				<nav>
					<h1 class="aside-title margin">추천사이트</h1>
					<ul>
						<li class="aside-menu-link"><a href=""><img alt="앤서이즈"
								src="../images/answeris.png"></a></li>
						<li class="aside-menu-link"><a href=""><img alt="W3C"
								src="../images/w3c.png"></a></li>
						<li class="aside-menu-link"><a href=""><img
								alt="마이크로 소프트" src="../images/microsoft.png"></a></li>
					</ul>
				</nav>
			</aside>


			<main id="main">

			<h2 class="main-title ">
				공지사항[<%=size %>]
			</h2>

			<div class="breadcrumb">
				<h3 class="hidden ">현재경로</h3>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>
			<form>
				<fieldset>
					<legend class="hidden">검색필드</legend>
					<label class="hidden">검색분류</label> <select name="f">
						<option value="TITLE" <%if(field.equals("TITLE")){%> selected
							<%} %>>제목</option>
						<option value="CONTENT" <%if(field.equals("CONTENT")){%> selected
							<%} %>>내용</option>
					</select> <label>검색어</label> <input name="q" type="text" value="<%=query%>"
						placeholder="검색어를 입력하세요" /> <input class="btn btn-search"
						type="submit" value="검색" /> <input type="hidden" name="p"
						value="1" />
				</fieldset>
			</form>

			<div class="notice margin">

				<h3 class="hidden">공지목록</h3>
				<script type="text/javascript">
					window.addEventListener("load", function() {
				
						var morebutton = document.querySelector("#more-button");
				
						var notices = [ {
							code : "1",
							title : "오오오"
						},
							{
								code : "2",
								title : "육육육"
							},
							{
								code : "3",
								title : "칠칠칠"
							} ];
				
				
						morebutton.onclick = function() {
				
							var template = document.querySelector("#notice-row");
				
							for (var i in notices) {
				
								var tbody = document.querySelector(".notice-table tbody");
				
								var tds = template.content.querySelectorAll("td");
				
								tds[0].innerText = notices[i].code;
								tds[1].innerText = notices[i].title;
				
								var clone = document.importNode(template.content, true);
								tbody.appendChild(clone);
							}
						};
				
					});
				</script>
				<template id="notice-row">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</template>
				<table class="table notice-table">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>

					<tbody>
						<% for(NoticeView v:list){%>
						<tr>
							<td><%=v.getCode() %></td>
							<td><%=v.getTitle() %></td>
							<td><%=v.getRegdate() %></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
			<%
                int last = (size % 10) > 0 ? size/10 + 1: size / 10 ;
               %>
			<div class="margin"><%=pg %>/<%=last %>
				pages
			</div>
			<div class="margin">
				<div>
					<a href="">이전</a>
				</div>
				<ul>
					<%for(int i=0;i<last;i++){%>
					<li><a href="?p<%=i+1%>&f=<%=field %>&q=<%= query %>"><%= i+1 %></a></li>

					<% } %>

				</ul>
				<div>
					<a href="">다음</a>
				</div>

				<div>
					<span id="more-button">더보기</span>
				</div>
			</div>
			</main>
		</div>
	</div>
	<!-- ------footer--------------------------------------------------- -->
	<footer id="footer">
		<div class="content-container">
			<h2>회사정보</h2>
			<div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
				Contact admin@newlecture.com for more information</div>
		</div>
	</footer>


</body>
</html>