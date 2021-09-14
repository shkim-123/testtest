<!-- ************************************************************* -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- ************************************************************* -->

<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함  -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<!-- 모든 JSP 페이지 상단에는 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ************************************************************* -->
<!-- 현재 JSP 페이지에서 사용할 클래스 수입하기 -->
<!-- ************************************************************* -->
<%@page import="com.naver.erp.dto.BoardDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- ************************************************************* -->
<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여 common.jsp 파일 내의 소스를 삽입하기 -->
<!-- ************************************************************* -->
<%@include file="../common.jsp" %>

<style>
	th {
		background-color: lightgray;
	}
</style>

<script>

	$(document).ready(function(){
		
	});

	function goBoardList(){
		location.replace('/boardList.do');
	}


	//----------------------------------------------------------------
	// 게시판 수정/삭제 화면으로 이동하는 함수 선언
	//----------------------------------------------------------------
	function goBoardUpDelForm() {

		//----------------------------------------------------------------
		// name="boardUpDelForm" 을 가진 form 태그의 action값을 URL로 서버에 접속하라
		//----------------------------------------------------------------
		document.boardUpDelForm.submit();
		
	}

	
	//----------------------------------------------------------------
	// 게시판 댓글 화면으로 이동하는 함수 선언
	//----------------------------------------------------------------
	function goBoardRegForm(){

		//----------------------------------------------------------------
		// name="boardRegForm" 을 가진 form 태그의 action값을 URL로 서버에 접속하라
		//----------------------------------------------------------------
		document.boardRegForm.submit();

	}
	
</script>

</head>
<body>

<center>

		<% 
			BoardDTO boardDTO = (BoardDTO)request.getAttribute("board"); 
			
			int b_no = 0;
		
		
			//----------------------------------------------------------------
			// boardDTO가 null이 아닐때 
			//----------------------------------------------------------------
			if(boardDTO != null) {
				b_no = boardDTO.getB_no();
				String subject = boardDTO.getSubject();
				String content = boardDTO.getContent();
				String writer = boardDTO.getWriter();
				String reg_date = boardDTO.getReg_date();
				int readcount = boardDTO.getReadcount();
				String email = boardDTO.getEmail();
			
		%>
		
	<table border="1">
		<caption><b>[글 상세 보기]</b></caption>
		<tr>
			<th>글번호</th>
			<td><%out.print(b_no);%></td>
			<th>조회수</th>
			<td><%out.print(readcount);%></td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td><%out.print(writer);%></td>
			<th>작성일</th>
			<td><%out.print(reg_date);%></td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td colspan="3"><%out.print(email);%></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td colspan="3"><%out.print(subject);%></td>
		</tr>
		

		
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea name="content" rows="13" cols="45" style="border:0" readonly><%out.print(content);%></textarea></td>
		</tr>
		
		<% 
			// if문 블록 닫기 
			} 
			// boardDTO 가 null 일 때
			else {
				out.print("<script>alert('삭제된 글입니다.'); goBoardList();</script>");
			}
		%>
		
	</table>
	
	<br>
	
	<input type="button" value="댓글쓰기" onClick="goBoardRegForm()">&nbsp;
	<input type="button" value="수정/삭제" onClick="goBoardUpDelForm()">&nbsp;
	<input type="button" value="목록보기" onClick="goBoardList()">
	
	<!-- ************************************************************* -->
	<!-- [게시판 수정/삭제] 화면으로 이동하는 form 태그 선언 -->
	<!-- 페이지 이동을 하는데 post 방식으로 데이터를 전달하고 싶으면 form 태그를 사용하는 수 밖에 없다. -->
	<!-- ************************************************************* -->
	<form name="boardUpDelForm" method="post" action="/boardUpDelForm.do">
		<input type="hidden" name="b_no" value="<%=b_no%>">
	</form>
	
	<!-- ************************************************************* -->
	<!-- [게시판 댓글쓰기] 화면으로 이동하는 form 태그 선언 -->
	<!-- 페이지 이동을 하는데 post 방식으로 데이터를 전달하고 싶으면 form 태그를 사용하는 수 밖에 없다. -->
	<!-- ************************************************************* -->
	<form name="boardRegForm" method="post" action="/boardRegForm.do">
		<input type="hidden" name="b_no" value="<%=b_no%>">
	</form>	
	
	
</center>

</body>
</html>