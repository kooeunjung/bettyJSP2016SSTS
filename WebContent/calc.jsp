			<!-- //코드블럭은 그 안으로 그냥 바로 옮겨가야함 -->
			<%
			
			String _x = request.getParameter("x"); //임시변수는 언더바
			String _y = request.getParameter("y");
			
			//x,y가 필수 입력 값이라면
		/*	int x = Integer.parseInt(_x);
			int y = Integer.parseInt(_y);*/
			
			
			//x,y가 필수가 아닌 옵션값이라면
			int x =0;
			int y =0;
			
			if(_x!=null &&  !_x.equals(""))//x가 전달된 것이 있다면
				x = Integer.parseInt(_x);
			if(_y!=null && !_y.equals(""))
				y = Integer.parseInt(_y);
			
			//쿼리 스트링이 전달되는 방식 3
			/*calc ->x=null
			calc?x=&y= x=""
			calc?x=1&y=2 ->x=1
			*/
					
			 %>
			 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안뇽 Jasper??</title>
</head>
<body>
	<!-- post 는 뭐지-->
	<form action="calc" method="get">
		<p>
			<label>x:</label> <input id="txt-x" /> <label>y:</label> <input
				id="txt-y" />
		</p>
		<p>
			sum= <input id="txt-sum" value="<%out.print(3+4);%>"/>
		</p>
		<p>
			<input id="btn-sum" type="button" value="sum">
		</p>
	</form>
</body>
</html>